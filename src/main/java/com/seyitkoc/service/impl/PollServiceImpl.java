package com.seyitkoc.service.impl;

import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.service.IPollService;
import com.seyitkoc.entity.Poll;
import com.seyitkoc.mapper.PollMapper;
import com.seyitkoc.repository.PollRepository;
import com.seyitkoc.dto.poll.DtoPollResult;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.entity.Building;
import com.seyitkoc.service.base.PollOptionBaseService;
import com.seyitkoc.mapper.PollOptionMapper;
import com.seyitkoc.dto.pollOption.DtoPollOption;
import com.seyitkoc.entity.User;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.poll.DtoPollIU;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IAnnouncementService;
import com.seyitkoc.service.IPollOptionService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PollServiceImpl implements IPollService {
    private final PollRepository pollRepository;
    private final IPollOptionService pollOptionService;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final PollMapper pollMapper;
    private final IAnnouncementService announcementService;
    private final PollOptionBaseService pollOptionBaseService;
    private final PollOptionMapper pollOptionMapper;

    public PollServiceImpl(PollRepository pollRepository, IPollOptionService pollOptionService, IUserService userService, JwtTokenService jwtTokenService, PollMapper pollMapper, IAnnouncementService announcementService, PollOptionBaseService pollOptionBaseService, PollOptionMapper pollOptionMapper) {
        this.pollRepository = pollRepository;
        this.pollOptionService = pollOptionService;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
        this.pollMapper = pollMapper;
        this.announcementService = announcementService;
        this.pollOptionBaseService = pollOptionBaseService;
        this.pollOptionMapper = pollOptionMapper;
    }

    @Transactional
    @Override
    public DtoPoll createPoll(DtoPollIU dtoPollIU, String token) {
        User user = userService.getUserByEmail(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")));

        userService.checkUserIsManagerOfBuilding(user, dtoPollIU.getBuildingId());
        Building building = user.getManagedBuildings().stream().filter(building1 -> building1.getId().equals(dtoPollIU.getBuildingId())).findFirst().orElseThrow(() -> new RuntimeException("Building not found"));
        Poll poll = new Poll();
        poll.setBuilding(building);
        poll.setTitle(dtoPollIU.getTitle());
        poll.setDescription(dtoPollIU.getDescription());
        poll.setActive(true);
        poll.setCreatedAt(LocalDateTime.now());
        poll.setFinishDate(LocalDateTime.now().plusDays(dtoPollIU.getTimeLimit()));
        Poll savedPoll = pollRepository.save(poll);
        pollOptionService.createPollOption(savedPoll, dtoPollIU.getOptions());

        announcementService.createAnnouncement("New Poll Created",
                "A new poll has been created: " + dtoPollIU.getTitle(),
                "system",
                building.getId(),
                building.getApartments().stream().map(Apartment::getId).toList()
        );


        return pollMapper.pollToDtoPoll(poll);
    }

    @Override
    public DtoPoll getPollById(Long pollId, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll not found"));

        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());
        return pollMapper.pollToDtoPoll(poll);
    }

    @Override
    @Transactional
    public String activatePoll(Long pollId, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll not found"));

        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());
        if (poll.isActive()) {
            throw new RuntimeException("Poll is already active.");
        }
        poll.setActive(true);
        pollRepository.save(poll);
        return "Poll activated successfully.";
    }

    @Override
    @Transactional
    public String deactivatePoll(Long pollId, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll not found"));
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());
        if (!poll.isActive()) {
            throw new RuntimeException("Poll is already not active.");
        }
        poll.setActive(false);
        pollRepository.save(poll);
        return "Poll deactivated successfully.";
    }


    @Override
    public DtoPollResult getPollResultById(Long pollId, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll not found"));

        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());
        return pollMapper.pollToDtoPollResult(poll);
    }

    @Override
    @Transactional
    public String updatePoll(Long pollId, DtoPollIU dtoPollIU, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll not found"));

        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());
        if (!dtoPollIU.getBuildingId().equals(poll.getBuilding().getId())) {
            throw new RuntimeException("Building IDs don't match!");
        }
        poll.setTitle(dtoPollIU.getTitle());
        poll.setDescription(dtoPollIU.getDescription());
        poll.setFinishDate(LocalDateTime.now().plusDays(dtoPollIU.getTimeLimit()));

        List<String> newOptionTexts = dtoPollIU.getOptions().stream().filter(optionText -> poll.getOptions().stream().noneMatch(option -> option.getOptionText().equals(optionText))).toList();
        if (!newOptionTexts.isEmpty()) {
            pollOptionService.createPollOption(poll, newOptionTexts);
        }

        poll.getOptions().removeIf(option ->
                dtoPollIU.getOptions().stream().noneMatch(text -> text.equals(option.getOptionText()))
        );
        Poll savedPoll = pollRepository.save(poll);

        announcementService.createAnnouncement("Poll Updated",
                "The poll has been updated: " + dtoPollIU.getTitle(),
                "system",
                savedPoll.getBuilding().getId(),
                savedPoll.getBuilding().getApartments().stream().map(Apartment::getId).toList()
        );
        return "Poll updated successfully.";
    }

    @Override
    public Page<DtoPollOption> getPollOptionsByPollId(
            Long pollId, int page, int pageSize, String sortBy, String sortDirection, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() ->
                new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Poll not found")));
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());

        return pollOptionBaseService.getPollOptionsByPollId(pollId, page, pageSize, sortBy, sortDirection)
                .map(pollOptionMapper::pollOptionToDtoPollOption);
    }
}

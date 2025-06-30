package com.seyitkoc.service.impl;

import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.poll.DtoPollIU;
import com.seyitkoc.dto.poll.DtoPollResult;
import com.seyitkoc.entity.polling.Poll;
import com.seyitkoc.entity.user.User;
import com.seyitkoc.mapper.PollMapper;
import com.seyitkoc.repository.PollRepository;
import com.seyitkoc.security.JwtTokenService;
import com.seyitkoc.service.IPollOptionService;
import com.seyitkoc.service.IPollService;
import com.seyitkoc.service.IUserService;
import com.seyitkoc.specification.PollSpecification;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PollServiceImpl implements IPollService {
    private final PollRepository pollRepository;
    private final IPollOptionService pollOptionService;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final PollMapper pollMapper;

    public PollServiceImpl(PollRepository pollRepository, IPollOptionService pollOptionService, IUserService userService, JwtTokenService jwtTokenService, PollMapper pollMapper) {
        this.pollRepository = pollRepository;
        this.pollOptionService = pollOptionService;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
        this.pollMapper = pollMapper;
    }

    @Transactional
    @Override
    public DtoPoll createPoll(DtoPollIU dtoPollIU, String token) {
        User user = userService.getUserByEmail(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")));

        userService.checkUserIsManagerOfBuilding(user, dtoPollIU.getBuildingId());

        Poll poll = new Poll();
        poll.setBuilding(user.getManagedBuildings().stream().filter(building -> building.getId().equals(dtoPollIU.getBuildingId())).findFirst().orElseThrow(() -> new RuntimeException("Building not found")));
        poll.setTitle(dtoPollIU.getTitle());
        poll.setDescription(dtoPollIU.getDescription());
        poll.setActive(true);
        poll.setCreatedAt(LocalDateTime.now());
        poll.setFinishDate(LocalDateTime.now().plusDays(dtoPollIU.getTimeLimit()));
        poll = pollRepository.save(poll);
        pollOptionService.createPollOption(poll, dtoPollIU.getOptions());
        poll = pollRepository.findById(poll.getId()).orElseThrow(() -> new RuntimeException("Poll not found"));
        return pollMapper.pollToDtoPoll(poll);
    }

    @Override
    public DtoPoll getPollById(Long pollId, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll not found"));

        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());
        return pollMapper.pollToDtoPoll(poll);
    }

    @Override
    public List<DtoPoll> getAllPollsByBuildingId(Long buildingId, String token) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), buildingId);
        return pollRepository.findAllByBuildingId(buildingId).stream().map(pollMapper::pollToDtoPoll).collect(Collectors.toList());
    }

    @Override
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
    public Page<DtoPoll> getPollsByFilter(
            Long buildingId,
            String isActive,
            String text,
            String minCreatedAt,
            String maxCreatedAt,
            String minFinishedAt,
            String maxFinishedAt,
            Long page,
            Long pageSize,
            String token) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), buildingId);
        Specification<Poll> spec = Specification.where(PollSpecification.hasBuildingId(buildingId));
        if (isActive != null) {
            spec = spec.and(PollSpecification.hasIsActive(Boolean.parseBoolean(isActive)));
        }
        if (text != null) {
            spec = spec.and(PollSpecification.hasTitle("%" + text + "%").or(PollSpecification.hasDescription("%" + text + "%")));
        }
        if (minCreatedAt != null) {
            spec = spec.and(PollSpecification.hasMinCreatedAt(Long.parseLong(minCreatedAt)));
        }
        if (maxCreatedAt != null) {
            spec = spec.and(PollSpecification.hasMaxCreatedAt(Long.parseLong(maxCreatedAt)));
        }
        if (minFinishedAt != null) {
            spec = spec.and(PollSpecification.hasMinFinishedAt(Long.parseLong(minFinishedAt)));
        }
        if (maxFinishedAt != null) {
            spec = spec.and(PollSpecification.hasMaxFinishedAt(Long.parseLong(maxFinishedAt)));
        }
        return pollRepository.findAll(spec, PageRequest.of(page == null ? 0 : page.intValue(), pageSize == null ? 0 : pageSize.intValue()))
                .map(pollMapper::pollToDtoPoll);
    }

    @Override
    public DtoPollResult getPollResultById(Long pollId, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll not found"));

        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());
        return pollMapper.pollToDtoPollResult(poll);
    }

    @Override
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
        pollRepository.save(poll);
        return "Poll updated successfully.";
    }
}

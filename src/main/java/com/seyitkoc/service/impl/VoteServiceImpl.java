package com.seyitkoc.service.impl;

import com.seyitkoc.service.IVoteService;
import com.seyitkoc.entity.Poll;
import com.seyitkoc.entity.User;
import com.seyitkoc.repository.PollRepository;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IUserService;
import com.seyitkoc.entity.Vote;
import com.seyitkoc.repository.VoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteServiceImpl implements IVoteService {
    private final PollRepository pollRepository;
    private final VoteRepository voteRepository;
    private final JwtTokenService jwtTokenService;
    private final IUserService userService;

    public VoteServiceImpl(PollRepository pollRepository, VoteRepository voteRepository, JwtTokenService jwtTokenService, IUserService userService) {
        this.pollRepository = pollRepository;
        this.voteRepository = voteRepository;
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
    }

    @Override
    @Transactional
    public Vote castVote(String token, Long pollId, Long apartmentId, Long voteOptionId) {
        User user = userService.getUserByEmail(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")));

        Optional<Poll> pollOptional = pollRepository.findById(pollId);
        if (pollOptional.isEmpty() || !pollOptional.get().isActive()) {
            throw new IllegalArgumentException("Poll not found or is closed");
        }
        Poll poll = pollOptional.get();
        if(poll.getVotes().stream().anyMatch(vote -> vote.getVoterApartmentId().equals(apartmentId))){
            throw new IllegalArgumentException("Already voted for this apartment in this poll");
        }

        // Check if the apartment is in the building.

        Vote newVote = new Vote();
        newVote.setPoll(poll);
        newVote.setVotedAt(java.time.LocalDateTime.now());
        newVote.setVoterName(user.getName());
        newVote.setVoter(user);
        newVote.setVoterApartmentId(apartmentId);
        newVote.setPollOption(poll.getOptions().stream()
                .filter(option -> option.getId().equals(voteOptionId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Vote option not found")));
        return voteRepository.save(newVote);
    }


}

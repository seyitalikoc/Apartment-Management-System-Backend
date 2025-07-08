package com.seyitkoc.controller;

import com.seyitkoc.service.IVoteService;
import com.seyitkoc.entity.Vote;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vote")
public class VoteController {
    private final IVoteService voteService;

    public VoteController(IVoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public Vote vote(
            @RequestHeader("authorization") String token,
            @RequestParam(name = "pollId") Long pollId,
            @RequestParam(name = "apartmentId") Long apartmentId,
            @RequestParam(name = "optionId") Long optionId) {
        return voteService.castVote(token, pollId, apartmentId, optionId);
    }
}

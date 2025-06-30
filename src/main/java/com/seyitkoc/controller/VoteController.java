package com.seyitkoc.controller;

import com.seyitkoc.entity.polling.Vote;
import com.seyitkoc.service.IVoteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vote")
public class VoteController {
    private final IVoteService voteService;

    public VoteController(IVoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/vote")
    public Vote vote(
            @RequestHeader("authorization") String token,
            @RequestParam(name = "pollId") Long pollId,
            @RequestParam(name = "apartmentId") Long apartmentId,
            @RequestParam(name = "optionId") Long optionId) {
        return voteService.castVote(token, pollId, apartmentId, optionId);
    }
}

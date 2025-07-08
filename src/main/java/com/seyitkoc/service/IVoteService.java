package com.seyitkoc.service;

import com.seyitkoc.entity.Vote;

public interface IVoteService {
    Vote castVote(String token, Long pollId, Long apartmentId, Long voteOptionId);
}

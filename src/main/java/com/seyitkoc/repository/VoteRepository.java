package com.seyitkoc.repository;

import com.seyitkoc.entity.polling.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query("SELECT v FROM Vote v WHERE v.poll.id = :pollId")
    List<Vote[]> getVoteResultsByPollId(@Param("pollId") Long pollId);
}
package com.seyitkoc.repository;

import com.seyitkoc.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PollRepository extends JpaRepository<Poll, Long>, JpaSpecificationExecutor<Poll> {
}

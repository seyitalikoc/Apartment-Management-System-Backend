package com.seyitkoc.repository;


import com.seyitkoc.entity.polling.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PollRepository extends JpaRepository<Poll, Long>, JpaSpecificationExecutor<Poll> {
    List<Poll> findAllByBuildingId(Long buildingId);
}

package com.seyitkoc.repository;

import com.seyitkoc.entity.PollOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PollOptionRepository extends JpaRepository<PollOption, Long>, JpaSpecificationExecutor<PollOption> {
}

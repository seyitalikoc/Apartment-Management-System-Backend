package com.seyitkoc.repository;

import com.seyitkoc.entity.polling.PollOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollOptionRepository extends JpaRepository<PollOption, Long> {
}

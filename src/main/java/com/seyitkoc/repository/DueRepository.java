package com.seyitkoc.repository;

import com.seyitkoc.entity.Due;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DueRepository extends JpaRepository<Due, Long> {
    Optional<Due> findDueByBuildingId(Long buildingId);

    List<Due> findAllByDayOfMonth(String dayOfMonth);

   Optional<Due> findDueById(Long dueId);
}

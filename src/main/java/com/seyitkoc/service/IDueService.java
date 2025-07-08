package com.seyitkoc.service;

import com.seyitkoc.entity.Due;
import com.seyitkoc.dto.due.DtoDue;
import com.seyitkoc.dto.due.DtoDueUpdate;
import com.seyitkoc.entity.Building;

import java.util.List;

public interface IDueService {

    List<Due> findAllByDayOfMonth ();
    void createDue(String dayOfMonth, Double amount, Building building);

    DtoDue updateDue(DtoDueUpdate dtoDueUpdate, Long dueId, String token);

    DtoDue getDueByBuildingId(Long dueId, String token);
}

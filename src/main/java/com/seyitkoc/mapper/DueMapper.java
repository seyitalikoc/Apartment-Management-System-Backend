package com.seyitkoc.mapper;

import com.seyitkoc.entity.Due;
import com.seyitkoc.dto.due.DtoDue;
import org.springframework.stereotype.Component;

@Component
public class DueMapper {
    public DtoDue toDtoDue(Due due) {
        return DtoDue.builder()
                .id(due.getId())
                .dayOfMonth(due.getDayOfMonth())
                .dueAmount(due.getDueAmount())
                .buildingId(due.getBuilding().getId())
                .build();
    }
}

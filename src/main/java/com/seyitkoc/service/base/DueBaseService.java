package com.seyitkoc.service.base;

import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.entity.Due;
import com.seyitkoc.repository.DueRepository;
import org.springframework.stereotype.Service;

@Service
public class DueBaseService {
    private final DueRepository dueRepository;

    public DueBaseService(DueRepository dueRepository) {
        this.dueRepository = dueRepository;
    }

    public Due getDueByBuildingId(Long buildingId){
        return dueRepository.findDueByBuildingId(buildingId).orElseThrow(()->
                new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND,"")));
    }
}


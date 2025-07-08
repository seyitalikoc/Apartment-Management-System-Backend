package com.seyitkoc.service.impl;

import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.entity.Due;
import com.seyitkoc.mapper.DueMapper;
import com.seyitkoc.repository.DueRepository;
import com.seyitkoc.service.IDueService;
import com.seyitkoc.dto.due.DtoDue;
import com.seyitkoc.dto.due.DtoDueUpdate;
import com.seyitkoc.entity.Building;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class DueServiceImpl implements IDueService {
    private final DueRepository dueRepository;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final DueMapper dueMapper;


    public DueServiceImpl(DueRepository dueRepository, IUserService userService, JwtTokenService jwtTokenService, DueMapper dueMapper) {
        this.dueRepository = dueRepository;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
        this.dueMapper = dueMapper;
    }

    @Override
    public List<Due> findAllByDayOfMonth() {
        return dueRepository.findAllByDayOfMonth(String.valueOf(LocalDate.now().getDayOfMonth()));
    }

    @Override
    public void createDue(String dayOfMonth, Double amount, Building building) {
        Due due = Due.builder()
                .dayOfMonth(dayOfMonth)
                .dueAmount(amount)
                .building(building)
                .build();

        dueRepository.save(due);
    }

    @Override
    public DtoDue updateDue(DtoDueUpdate dtoDueUpdate, Long dueId, String token) {
        Due due = dueRepository.findDueById(dueId)
                .orElseThrow(()-> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND,"")));

        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), due.getBuilding().getId());

        due.setDayOfMonth(dtoDueUpdate.getDayOfMonth());
        due.setDueAmount(dtoDueUpdate.getAmount());

        return dueMapper.toDtoDue(dueRepository.save(due));
    }

    @Override
    public DtoDue getDueByBuildingId(Long dueId, String token) {
        Due due = dueRepository.findDueById(dueId)
                .orElseThrow(()-> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND,"")));
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), due.getBuilding().getId());

        return dueMapper.toDtoDue(due);
    }
}

package com.seyitkoc.service;

import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.poll.DtoPollIU;
import com.seyitkoc.dto.poll.DtoPollResult;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPollService {
    DtoPoll createPoll(@Valid DtoPollIU dtoPollIU, String token);
    DtoPoll getPollById(Long pollId, String token);
    List<DtoPoll> getAllPollsByBuildingId(Long buildingId, String token);
    String activatePoll(Long pollId, String token);
    String deactivatePoll(Long pollId, String token);
    Page<DtoPoll> getPollsByFilter(Long buildingId, String isActive, String text, String minCreatedAt, String maxCreatedAt, String minFinishedAt, String maxFinishedAt, Long page, Long pageSize, String token);
    DtoPollResult getPollResultById(Long pollId, String token);

    String updatePoll(Long pollId, @Valid DtoPollIU dtoPollIU, String token);
}

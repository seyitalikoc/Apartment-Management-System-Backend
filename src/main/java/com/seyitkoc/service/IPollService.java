package com.seyitkoc.service;

import com.seyitkoc.dto.poll.DtoPollResult;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.poll.DtoPollIU;
import com.seyitkoc.dto.pollOption.DtoPollOption;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

public interface IPollService {
    DtoPoll createPoll(@Valid DtoPollIU dtoPollIU, String token);
    DtoPoll getPollById(Long pollId, String token);
    String activatePoll(Long pollId, String token);
    String deactivatePoll(Long pollId, String token);
    DtoPollResult getPollResultById(Long pollId, String token);

    String updatePoll(Long pollId, @Valid DtoPollIU dtoPollIU, String token);

    Page<DtoPollOption> getPollOptionsByPollId(
            Long pollId, int page, int pageSize, String sortBy, String sortDirection, String token);
}

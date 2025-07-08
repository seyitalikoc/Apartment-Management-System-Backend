package com.seyitkoc.mapper;

import com.seyitkoc.entity.Poll;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.poll.DtoPollResult;
import com.seyitkoc.dto.poll.DtoPollResultItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class PollMapper {
    private final PollOptionMapper pollOptionMapper;

    public PollMapper(PollOptionMapper pollOptionMapper) {
        this.pollOptionMapper = pollOptionMapper;
    }

    public DtoPoll pollToDtoPoll(Poll poll) {
        DtoPoll dtoPoll = new DtoPoll();
        dtoPoll.setId(poll.getId());
        dtoPoll.setTitle(poll.getTitle());
        dtoPoll.setDescription(poll.getDescription());
        dtoPoll.setBuildingId(poll.getBuilding().getId());
        dtoPoll.setCreatedAt(poll.getCreatedAt().toString());
        dtoPoll.setFinishedAt(poll.getFinishDate() != null ? poll.getFinishDate().toString() : null);
        dtoPoll.setActive(poll.isActive());
        dtoPoll.setOptions(poll.getOptions() != null ? poll.getOptions().stream()
                .map(pollOptionMapper::pollOptionToDtoPollOption)
                .toList() : null);
        dtoPoll.setVotes(poll.getVotes() != null ? poll.getVotes() : null);
        return dtoPoll;
    }

    public DtoPollResult pollToDtoPollResult(Poll poll) {
        DtoPollResult dtoPollResult = new DtoPollResult();
        dtoPollResult.setPoll(pollToDtoPoll(poll));
        dtoPollResult.setItems( poll.getOptions() != null ? poll.getOptions().stream().map(
                option -> {
                    DtoPollResultItem dtoPollResultItem = new DtoPollResultItem();
                    dtoPollResultItem.setOption(pollOptionMapper.pollOptionToDtoPollOption(option));
                    dtoPollResultItem.setCount(poll.getVotes().stream().filter(vote -> vote.getPollOption().equals(option)).count());
                    return dtoPollResultItem;
                }
        ).collect(Collectors.toList()) : new ArrayList<>());
        return dtoPollResult;
    }
}

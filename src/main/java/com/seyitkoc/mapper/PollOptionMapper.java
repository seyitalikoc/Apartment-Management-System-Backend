package com.seyitkoc.mapper;

import com.seyitkoc.dto.poll.DtoPollOption;
import com.seyitkoc.entity.polling.PollOption;
import org.springframework.stereotype.Component;

@Component
public class PollOptionMapper {
    public DtoPollOption pollOptionToDtoPollOption(PollOption pollOption) {
        DtoPollOption dtoPollOption = new DtoPollOption();
        dtoPollOption.setId(pollOption.getId());
        dtoPollOption.setOptionText(pollOption.getOptionText());
        return dtoPollOption;
    }
}


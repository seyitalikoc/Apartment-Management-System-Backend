package com.seyitkoc.mapper;

import com.seyitkoc.entity.PollOption;
import com.seyitkoc.dto.pollOption.DtoPollOption;
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


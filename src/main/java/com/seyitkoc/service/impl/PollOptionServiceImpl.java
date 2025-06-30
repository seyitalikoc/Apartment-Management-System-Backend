package com.seyitkoc.service.impl;

import com.seyitkoc.entity.polling.Poll;
import com.seyitkoc.entity.polling.PollOption;
import com.seyitkoc.repository.PollOptionRepository;
import com.seyitkoc.service.IPollOptionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PollOptionServiceImpl implements IPollOptionService {
    private final PollOptionRepository pollOptionRepository;

    public PollOptionServiceImpl(PollOptionRepository pollOptionRepository) {
        this.pollOptionRepository = pollOptionRepository;
    }

    @Override
    public void createPollOption(Poll poll, List<String> options) {
        List<PollOption> pollOptions = options.stream()
                .map(option -> {
                    PollOption pollOption = new PollOption();
                    pollOption.setPoll(poll);
                    pollOption.setOptionText(option);
                    return pollOption;
                })
                .collect(Collectors.toList());
        pollOptionRepository.saveAll(pollOptions);
    }
}

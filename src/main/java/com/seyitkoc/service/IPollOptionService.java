package com.seyitkoc.service;

import com.seyitkoc.entity.polling.Poll;

import java.util.List;

public interface IPollOptionService {
    void createPollOption(Poll poll, List<String> options);
}

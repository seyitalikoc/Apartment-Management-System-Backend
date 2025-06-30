package com.seyitkoc.service;

import java.time.LocalDateTime;

public interface IHashService {
    String calculateHash(Integer index, LocalDateTime timestamp, String voterName, Long voterApartmentId,  String voteOption, String previousHash);
    String getGenesisHash();
}

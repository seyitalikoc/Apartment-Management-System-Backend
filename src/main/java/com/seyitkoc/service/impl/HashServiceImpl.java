package com.seyitkoc.service.impl;

import com.seyitkoc.service.IHashService;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Service
public class HashServiceImpl implements IHashService {

    @Override
    public String calculateHash(Integer index, LocalDateTime timestamp, String voterName, Long voterApartmentId, String voteOption, String previousHash) {
        try{
            String data = index + timestamp.toString() + voterName + voterApartmentId + voteOption + previousHash;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Error calculating hash", e);
        }
    }

    @Override
    public String getGenesisHash() {
        return "0000000000000000000000000000000000000000000000000000000000000000";
    }
}

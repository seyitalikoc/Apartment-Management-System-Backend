package com.seyitkoc.mapper;

import com.seyitkoc.entity.Auth;
import com.seyitkoc.dto.auth.DtoAuth;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {
    public DtoAuth toDtoAuthWithToken(Auth auth, String token) {
        return new DtoAuth(auth.getEmail(), auth.getRole().name(), auth.getUser().getId(), token);
    }

    public DtoAuth toDtoAuthWithoutToken(Auth auth) {
        return new DtoAuth(auth.getEmail(), auth.getRole().name(), auth.getUser().getId(), null);
    }
}

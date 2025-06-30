package com.seyitkoc.service;

import com.seyitkoc.dto.auth.LoginRequest;
import com.seyitkoc.dto.auth.DtoAuth;
import com.seyitkoc.dto.auth.DtoAuthEmailUpdate;
import com.seyitkoc.dto.auth.DtoAuthPasswordUpdate;
import com.seyitkoc.entity.auth.Auth;

public interface IAuthService {
    Auth createNewAuth(String email, String password);

    DtoAuth getAuthInfos(String token);

    String updateAuthPassword(String token, DtoAuthPasswordUpdate dtoAuthUpdate);

    String updateAuthEmail(String token, DtoAuthEmailUpdate dtoAuthEmailUpdate);

    String deleteAuth(String token);

    DtoAuth login(LoginRequest loginRequest);

    Auth getAuthByToken(String token);
}

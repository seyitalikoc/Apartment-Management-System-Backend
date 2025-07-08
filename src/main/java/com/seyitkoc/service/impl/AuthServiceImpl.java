package com.seyitkoc.service.impl;

import com.seyitkoc.entity.Auth;
import com.seyitkoc.mapper.AuthMapper;
import com.seyitkoc.repository.AuthRepository;
import com.seyitkoc.service.IAuthService;
import com.seyitkoc.dto.auth.LoginRequest;
import com.seyitkoc.dto.auth.DtoAuth;
import com.seyitkoc.dto.auth.DtoAuthEmailUpdate;
import com.seyitkoc.dto.auth.DtoAuthPasswordUpdate;
import com.seyitkoc.enums.AuthRole;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    private final AuthRepository authRepository;
    private final JwtTokenService jwtTokenService;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthRepository authRepository, JwtTokenService jwtTokenService, AuthMapper authMapper, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.jwtTokenService = jwtTokenService;
        this.authMapper = authMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Auth createNewAuth(String email, String password, User user) {
        checkIsEmailUsable(email);

        Auth auth = new Auth();
        auth.setEmail(email);
        auth.setPassword(new BCryptPasswordEncoder().encode(password));
        auth.setRole(AuthRole.ROLE_USER);
        auth.setUser(user);
        return authRepository.save(auth);
    }

    @Override
    public DtoAuth getAuthInfos(String token) {
        if (jwtTokenService.isTokenBlacklisted(token)) {
            throw new ApplicationException(new ErrorMessage(MessageType.TOKEN_EXPIRED, ""));
        }
        Auth auth = getAuthByToken(token);
        if (auth == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, ""));
        }
        return authMapper.toDtoAuthWithoutToken(auth);
    }

    private void checkIsEmailUsable(String email) {
        if (authRepository.findAuthByEmail(email).isPresent())
            throw new ApplicationException(new ErrorMessage(MessageType.EMAIL_EXISTS, ""));
    }

    @Override
    public String updateAuthPassword(String token, DtoAuthPasswordUpdate dtoAuthPasswordUpdate) {
        if (jwtTokenService.isTokenBlacklisted(token)) {
            throw new ApplicationException(new ErrorMessage(MessageType.TOKEN_EXPIRED, ""));
        }
        Auth auth = getAuthByToken(token);
        if (!passwordEncoder.matches(dtoAuthPasswordUpdate.getOldPassword(), auth.getPassword())) {
            throw new ApplicationException(new ErrorMessage(MessageType.INVALID_CREDENTIALS, ""));
        }
        auth.setPassword(new BCryptPasswordEncoder().encode(dtoAuthPasswordUpdate.getNewPassword()));
        Auth savedAuth = authRepository.save(auth);
        if (savedAuth.getId() == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.INTERNAL_SERVER_ERROR, "Failed to update password"));
        }
        if (!jwtTokenService.isTokenBlacklisted(token)) {
            jwtTokenService.blacklistToken(token);
        }
        return "Password updated successfully.";
    }

    @Override
    public String updateAuthEmail(String token, DtoAuthEmailUpdate dtoAuthEmailUpdate) {
        if (jwtTokenService.isTokenBlacklisted(token)) {
            throw new ApplicationException(new ErrorMessage(MessageType.TOKEN_EXPIRED, ""));
        }
        Auth auth = getAuthByToken(token);
        if (!auth.getEmail().equals(dtoAuthEmailUpdate.getOldEmail()) || !passwordEncoder.matches(dtoAuthEmailUpdate.getPassword(), auth.getPassword())) {
            throw new ApplicationException(new ErrorMessage(MessageType.INVALID_CREDENTIALS, ""));
        }
        checkIsEmailUsable(dtoAuthEmailUpdate.getNewEmail());

        auth.setEmail(dtoAuthEmailUpdate.getNewEmail());
        auth = authRepository.save(auth);
        if (auth.getId() == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.INTERNAL_SERVER_ERROR, "Failed to update email"));
        }
        if (!jwtTokenService.isTokenBlacklisted(token)) {
            jwtTokenService.blacklistToken(token);
        }
        return "Email updated successfully.";
    }

    @Override
    public DtoAuth login(LoginRequest loginRequest) {
        Auth auth = authRepository.findAuthByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, "")));
        if(!passwordEncoder.matches(loginRequest.getPassword(),auth.getPassword())){
            throw new RuntimeException("");
        }
        return authMapper.toDtoAuthWithToken(auth, jwtTokenService.generateToken(auth));
    }

    @Override
    public String deleteAuth(String token) {
        if (jwtTokenService.isTokenBlacklisted(token)) {
            throw new ApplicationException(new ErrorMessage(MessageType.TOKEN_EXPIRED, ""));
        }
        Auth auth = getAuthByToken(token);
        authRepository.delete(auth);
        if (!jwtTokenService.isTokenBlacklisted(token)) {
            jwtTokenService.blacklistToken(token);
        }
        return "User deleted successfully.";
    }


    public Auth getAuthByToken(String token) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", "").trim());
        return authRepository.findAuthByEmail(email)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, "")));
    }
}

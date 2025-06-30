package com.seyitkoc.controller;

import com.seyitkoc.dto.ApiResponse;
import com.seyitkoc.dto.auth.LoginRequest;
import com.seyitkoc.dto.auth.DtoAuth;
import com.seyitkoc.dto.auth.DtoAuthEmailUpdate;
import com.seyitkoc.dto.auth.DtoAuthPasswordUpdate;
import com.seyitkoc.service.IAuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ApiResponse<DtoAuth> login(@RequestBody LoginRequest loginRequest) {
        return ApiResponse.ok(authService.login(loginRequest));
    }

    @GetMapping("/get-auth-infos")
    public ApiResponse<DtoAuth> getAuthInfos(@RequestHeader("authorization") String token) {
        return ApiResponse.ok(authService.getAuthInfos(token));
    }

    @PutMapping("/update-password")
    public ApiResponse<String> updateAuth(@RequestHeader("authorization") String token, @RequestBody DtoAuthPasswordUpdate dtoAuthPasswordUpdate) {
        return ApiResponse.ok(authService.updateAuthPassword(token, dtoAuthPasswordUpdate));
    }

    @PutMapping("/update-email")
    public ApiResponse<String> updateAuthEmail(@RequestHeader("authorization") String token, @RequestBody DtoAuthEmailUpdate dtoAuthEmailUpdate) {
        return ApiResponse.ok(authService.updateAuthEmail(token, dtoAuthEmailUpdate));
    }

    @DeleteMapping("/delete")
    public ApiResponse<String> deleteAuth(@RequestHeader("authorization") String token) {
        return ApiResponse.ok(authService.deleteAuth(token));
    }
}

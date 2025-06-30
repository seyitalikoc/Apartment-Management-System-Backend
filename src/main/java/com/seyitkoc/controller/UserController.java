package com.seyitkoc.controller;

import com.seyitkoc.dto.ApiResponse;
import com.seyitkoc.dto.user.DtoUser;
import com.seyitkoc.dto.user.DtoUserCreate;
import com.seyitkoc.dto.user.DtoUserUpdate;
import com.seyitkoc.service.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-user-info")
    public ApiResponse<DtoUser> getUserInfo(@RequestHeader("Authorization") String token, @RequestParam(required = false) Long id){
        return ApiResponse.ok(userService.getUserByTokenAndId(token, id));
    }

    @PostMapping("/save")
    public ApiResponse<String> createNewUser(@RequestBody DtoUserCreate dtoUserCreate){
        return ApiResponse.ok(userService.createNewUser(dtoUserCreate));
    }

    @PutMapping("/update")
    public ApiResponse<String> updateUser(@RequestBody DtoUserUpdate dtoUserUpdate, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(userService.updateUser(token, dtoUserUpdate));
    }

    @DeleteMapping("/delete")
    public ApiResponse<String> deleteUser(@RequestHeader("Authorization") String token) {
        return ApiResponse.ok(userService.deleteUser(token));
    }
}

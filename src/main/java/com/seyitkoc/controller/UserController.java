package com.seyitkoc.controller;

import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.service.IUserService;
import com.seyitkoc.dto.user.DtoUser;
import com.seyitkoc.dto.user.DtoUserCreate;
import com.seyitkoc.dto.user.DtoUserUpdate;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ApiResponse<DtoUser> getUserInfo(@RequestHeader("Authorization") String token, @RequestParam(name = "id", required = false) Long id){
        return ApiResponse.ok(userService.getUserByTokenAndId(token, id));
    }

    @PostMapping
    public ApiResponse<String> createNewUser(@Valid @RequestBody DtoUserCreate dtoUserCreate){
        return ApiResponse.ok(userService.createNewUser(dtoUserCreate));
    }

    @PutMapping
    public ApiResponse<String> updateUser(@RequestBody DtoUserUpdate dtoUserUpdate, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(userService.updateUser(token, dtoUserUpdate));
    }

    @DeleteMapping
    public ApiResponse<String> deleteUser(@RequestHeader("Authorization") String token) {
        return ApiResponse.ok(userService.deleteUser(token));
    }

    @GetMapping("/apartments/owner")
    public ApiResponse<Page<DtoApartment>> getOwnerApartmentsByUser(
            @RequestHeader(value = "Authorization") String token,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection){
        return ApiResponse.ok(userService.getOwnerApartmentsByUser(token, page, size, sortBy, sortDirection));
    }

    @GetMapping("/apartments/rented")
    public ApiResponse<DtoApartment> getRentedApartmentByUser(
            @RequestHeader(value = "Authorization") String token){
        return ApiResponse.ok(userService.getRentedApartmentByUser(token));
    }

    @GetMapping("/buildings")
    public ApiResponse<Page<DtoBuilding>> getBuildingsByUser(
            @RequestHeader(value = "Authorization") String token,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection){
        return ApiResponse.ok(userService.getBuildingsByUser(token, page, size, sortBy, sortDirection));
    }


}

package com.seyitkoc.controller;

import com.seyitkoc.dto.ApiResponse;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.service.IApartmentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/apartments")
public class ApartmentController {
    private final IApartmentService apartmentService;

    public ApartmentController(IApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping("/{apartmentId}/get")
    public ApiResponse<DtoApartment> getApartmentById(@PathVariable(name = "apartmentId") Long apartmentId, @RequestHeader("Authorization") String token){
        return ApiResponse.ok(apartmentService.getApartmentById(token, apartmentId));
    }

    @GetMapping("/getByBuilding/{buildingId}")
    public ApiResponse<Page<DtoApartment>> getAllApartmentsByBuildingId(
            @RequestHeader("Authorization") String token,
            @PathVariable(name = "buildingId") Long buildingId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection) {
        return ApiResponse.ok(apartmentService.getAllApartmentsByBuildingId(token, buildingId, page, size, sortBy, sortDirection));
    }

    @PatchMapping("/{apartmentId}/setOwner")
    public ApiResponse<DtoApartment> setApartmentOwner(
            @PathVariable(name = "apartmentId") Long apartmentId,
            @RequestParam(name = "userId") Long userId,
            @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentService.setApartmentOwner(token, apartmentId, userId));
    }

    @PatchMapping("/{apartmentId}/setTenant")
    public ApiResponse<DtoApartment> setApartmentTenant(
            @PathVariable(name = "apartmentId") Long apartmentId,
            @RequestParam(name = "userId") Long userId,
            @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentService.setApartmentTenant(token, apartmentId, userId));
    }
}

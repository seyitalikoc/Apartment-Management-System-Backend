package com.seyitkoc.controller;

import com.seyitkoc.dto.ApiResponse;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.dto.building.DtoBuildingIU;
import com.seyitkoc.service.IBuildingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
public class BuildingController {
    private final IBuildingService buildingService;

    public BuildingController(IBuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping("{id}/get")
    public ApiResponse<DtoBuilding> getBuildingById(@RequestHeader("authorization") String token, @PathVariable(name = "id") Long buildingId){
        return ApiResponse.ok(buildingService.getBuildingById(token, buildingId));
    }

    @PostMapping("/save")
    public ApiResponse<String> saveBuilding(@RequestBody DtoBuildingIU dtoBuildingIU) {
        return ApiResponse.ok(buildingService.saveBuilding(dtoBuildingIU));
    }

    @PutMapping("{id}/change-manager")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ApiResponse<DtoBuilding> changeManager(@RequestParam(value = "managerId") Long managerId, @PathVariable(name = "id") Long buildingId) {
        return ApiResponse.ok(buildingService.changeManager(buildingId, managerId));
    }

    @PutMapping("{id}/update")
    public ApiResponse<String> updateBuilding(@RequestBody DtoBuildingIU dtoBuildingIU, @PathVariable Long id, @RequestHeader("authorization") String token) {
        return ApiResponse.ok(buildingService.updateBuilding(dtoBuildingIU, id, token));
    }

    @PatchMapping("/{id}/status")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ApiResponse<String> updateBuildingStatus(@PathVariable Long id, @RequestParam(name = "status") String status) {
        return ApiResponse.ok(buildingService.updateBuildingStatus(id, status));
    }

    @DeleteMapping("{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ApiResponse<String> deleteBuilding(@PathVariable Long id) {
        return ApiResponse.ok( buildingService.deleteBuilding(id));
    }
}

package com.seyitkoc.controller;

import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.service.IDueService;
import com.seyitkoc.dto.due.DtoDue;
import com.seyitkoc.dto.due.DtoDueUpdate;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dues")
public class DueController {
    private final IDueService dueService;

    public DueController(IDueService dueService) {
        this.dueService = dueService;
    }

    @GetMapping("{id}")
    public ApiResponse<DtoDue> getDueByBuildingId(@PathVariable(name = "id") Long dueId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(dueService.getDueByBuildingId(dueId, token));
    }

    @PutMapping("{id}")
    public ApiResponse<DtoDue> updateDue(@Valid @RequestBody DtoDueUpdate dtoDueUpdate, @PathVariable(name = "id") Long dueId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(dueService.updateDue(dtoDueUpdate, dueId, token));
    }
}

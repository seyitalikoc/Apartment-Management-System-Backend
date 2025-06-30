package com.seyitkoc.controller;

import com.seyitkoc.dto.ApiResponse;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.poll.DtoPollIU;
import com.seyitkoc.dto.poll.DtoPollResult;
import com.seyitkoc.service.IPollService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/poll")
public class PollController {
    private final IPollService pollService;

    public PollController(IPollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping("/create")
    public ApiResponse<DtoPoll> createPoll(@Valid @RequestBody DtoPollIU dtoPollIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.createPoll(dtoPollIU, token));
    }

    @GetMapping("/getByFilter")
    public ApiResponse<Page<DtoPoll>> getPollsByFilter(
            @RequestParam Long buildingId,
            @RequestParam(required = false) String isActive,
            @RequestParam(required = false) String text,
            @RequestParam(required = false) String minCreatedAt,
            @RequestParam(required = false) String maxCreatedAt,
            @RequestParam(required = false) String minFinishedAt,
            @RequestParam(required = false) String maxFinishedAt,
            @RequestParam(required = false) Long page,
            @RequestParam(required = false) Long pageSize,
            @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.getPollsByFilter(buildingId, isActive, text, minCreatedAt, maxCreatedAt, minFinishedAt, maxFinishedAt, page, pageSize, token));
    }

    @GetMapping("/get/{pollId}")
    public ApiResponse<DtoPoll> getPollById(@PathVariable Long pollId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.getPollById(pollId, token));
    }

    @GetMapping("/get/{pollId}/results")
    public ApiResponse<DtoPollResult> getPollResults(@PathVariable Long pollId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.getPollResultById(pollId, token));
    }

    @GetMapping("/getAllByBuilding/{buildingId}")
    public ApiResponse<List<DtoPoll>> getAllPolls(@PathVariable Long buildingId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.getAllPollsByBuildingId(buildingId, token));
    }

    @PatchMapping("/activate/{pollId}")
    public ApiResponse<String> activatePoll(@PathVariable Long pollId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.activatePoll(pollId, token));
    }

    @PatchMapping("/deactivate/{pollId}")
    public ApiResponse<String> deactivatePoll(@PathVariable Long pollId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.deactivatePoll(pollId, token));
    }

    @PutMapping("/update/{pollId}")
    public ApiResponse<String> updatePoll(@PathVariable Long pollId, @Valid @RequestBody DtoPollIU dtoPollIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.updatePoll(pollId, dtoPollIU, token));
    }


}

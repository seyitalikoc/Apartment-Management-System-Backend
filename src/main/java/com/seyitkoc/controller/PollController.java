package com.seyitkoc.controller;

import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.service.IPollService;
import com.seyitkoc.dto.poll.DtoPollResult;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.poll.DtoPollIU;
import com.seyitkoc.dto.pollOption.DtoPollOption;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/polls")
public class PollController {
    private final IPollService pollService;

    public PollController(IPollService pollService) {
        this.pollService = pollService;
    }

    // CRUD Operations
    @PostMapping
    public ApiResponse<DtoPoll> createPoll(@Valid @RequestBody DtoPollIU dtoPollIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.createPoll(dtoPollIU, token));
    }

    @GetMapping("{id}")
    public ApiResponse<DtoPoll> getPollById(@PathVariable(name = "id") Long pollId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.getPollById(pollId, token));
    }

    @PutMapping("{id}")
    public ApiResponse<String> updatePoll(@PathVariable(name = "id") Long pollId, @Valid @RequestBody DtoPollIU dtoPollIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.updatePoll(pollId, dtoPollIU, token));
    }

    @GetMapping("{id}/options")
    public ApiResponse<Page<DtoPollOption>> getPollOptionsByPollId(
            @PathVariable(name = "id") Long pollId,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDirection", required = false, defaultValue = "ASC") String sortDirection,

            @RequestHeader(value = "Authorization") String token
    ){
        return ApiResponse.ok(pollService.getPollOptionsByPollId(pollId, page, pageSize, sortBy, sortDirection, token));
    }

    @GetMapping("{id}/results")
    public ApiResponse<DtoPollResult> getPollResults(@PathVariable(name = "id") Long pollId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.getPollResultById(pollId, token));
    }

    // id/votes is addable here, it returns user votes by poll id.


    // Special Operations
    @PatchMapping("{id}/setActive")
    public ApiResponse<String> activatePoll(@PathVariable(name = "id") Long pollId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.activatePoll(pollId, token));
    }

    @PatchMapping("{id}/setPassive")
    public ApiResponse<String> deactivatePoll(@PathVariable(name = "id") Long pollId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.deactivatePoll(pollId, token));
    }
}

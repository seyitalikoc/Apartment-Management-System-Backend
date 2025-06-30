package com.seyitkoc.dto.poll;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoPollIU {
    @NotBlank(message = "Poll title cannot be blank.")
    private String title;

    @NotBlank(message = "Poll description cannot be blank.")
    private String description;

    private Long timeLimit;

    private Long buildingId;

    @NotEmpty(message = "Poll options cannot be empty.")
    private List<String> options;
}

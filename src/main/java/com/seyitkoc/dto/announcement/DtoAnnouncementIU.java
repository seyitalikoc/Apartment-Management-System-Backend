package com.seyitkoc.dto.announcement;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoAnnouncementIU {
    @Size(min = 1, max = 100)
    private String title;

    @Size(min = 1, max = 250)
    private String content;

    @Size(min = 1, max = 50)
    private String createdBy;

    @NotNull
    private Long buildingId;

    @NotEmpty
    private List<Long> apartmentIds; // Changed from List<Long> to Long[] for consistency with the service interface
}

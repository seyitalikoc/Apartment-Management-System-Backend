package com.seyitkoc.dto.announcement;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoAnnouncement {
    private Long id;
    private String title;
    private String content;
    private String createdBy;
    private Long buildingId;
    private String buildingName;
    private List<Long> apartmentIds;
    private List<Long> apartmentNumbers;
    private String createdAt;
    private String updatedAt;
}

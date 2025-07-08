package com.seyitkoc.dto.poll;

import com.seyitkoc.dto.pollOption.DtoPollOption;
import com.seyitkoc.entity.Vote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoPoll {
    private Long id;
    private String title;
    private String description;
    private Long buildingId;
    private String createdAt;
    private String finishedAt;
    private boolean isActive;
    private List<DtoPollOption> options;
    private List<Vote> votes;
}

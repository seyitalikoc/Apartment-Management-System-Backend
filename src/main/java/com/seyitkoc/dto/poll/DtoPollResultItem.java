package com.seyitkoc.dto.poll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoPollResultItem {
    private DtoPollOption option;
    private Long count;
}

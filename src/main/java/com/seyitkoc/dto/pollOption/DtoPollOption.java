package com.seyitkoc.dto.pollOption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoPollOption {
    private Long id;
    private String optionText;
}

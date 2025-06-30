package com.seyitkoc.dto.poll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoPollResult {
    DtoPoll poll;
    List<DtoPollResultItem> items;
}

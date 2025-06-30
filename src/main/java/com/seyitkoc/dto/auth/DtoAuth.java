package com.seyitkoc.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoAuth {
    private String email;
    private String role;
    private Long userId;
    private String token;
}

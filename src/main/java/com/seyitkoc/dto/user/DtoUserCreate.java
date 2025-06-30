package com.seyitkoc.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoUserCreate {
    private String email;
    private String password;
    private String name;
    private String phone;
}

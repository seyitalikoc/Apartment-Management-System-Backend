package com.seyitkoc.dto.auth;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoAuthPasswordUpdate {
    @Size(min = 8, max = 24, message = "Old password must be between 8 and 24 characters.")
    private String oldPassword;
    @Size(min = 8, max = 24, message = "New password must be between 8 and 24 characters.")
    private String newPassword;
}

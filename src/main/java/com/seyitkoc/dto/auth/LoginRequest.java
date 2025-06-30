package com.seyitkoc.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginRequest {
    @Email(message = "Invalid email format")
    private String email;
    @Size(min = 8, max = 24, message = "Password must be between 8 and 24 characters")
    private String password;
}

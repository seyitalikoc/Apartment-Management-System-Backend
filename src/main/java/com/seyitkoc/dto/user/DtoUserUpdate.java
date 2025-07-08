package com.seyitkoc.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoUserUpdate {
    @NotNull
    private Long id;

    @Size(min = 1, max = 100)
    private String name;

    @Pattern(regexp = "^\\+90\\d{10}$", message = "Phone number must be in the format +90XXXXXXXXXX")
    private String phone;
}

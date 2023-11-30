package com.security.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignIn {
    @NotBlank
    private String userName;

    @NotBlank
    private String password;
}

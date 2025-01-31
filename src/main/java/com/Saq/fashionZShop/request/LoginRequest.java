package com.Saq.fashionZShop.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoginRequest {
    @NotBlank
    String email;
    @NotBlank
    String password;
}

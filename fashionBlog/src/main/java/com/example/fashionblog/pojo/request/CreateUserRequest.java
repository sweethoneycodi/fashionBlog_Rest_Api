package com.example.fashionblog.pojo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class CreateUserRequest {
    @NotNull(message = "required")
    private String firstName;

    @NotNull(message = "required")
    private String lastName;

    @Email
    private String email;

    @NotNull(message = "required")
    private String password;
}

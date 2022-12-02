package com.example.fashionblog.pojo.request;

import com.example.fashionblog.enums.Role;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class CreateAdminRequest {
    @NotNull(message = "required")
    private String firstName;

    @NotNull(message = "required")
    private String lastName;

    @Email
    private String email;

    @Enumerated
    private Role role;

    @NotNull(message = "required")
    private String password;
}

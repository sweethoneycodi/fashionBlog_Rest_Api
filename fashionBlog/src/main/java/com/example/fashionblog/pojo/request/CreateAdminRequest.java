package com.example.fashionblog.pojo.request;

import com.example.fashionblog.enums.Role;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdminRequest {
    @NotNull(message = "required")
    private String firstName;

    @NotNull(message = "required")
    private String lastName;

    @Email
    private String email;

    //@Enumerated
   // private Role role;

    @NotNull(message = "required")
    private String password;
}

package com.example.fashionblog.dto;

import lombok.*;

import java.io.Serializable;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    public static Long serialVersionUID = 1L;
    private Long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
    private String emailVerificationToken;
    private boolean emailVerificationStatus = false;

}

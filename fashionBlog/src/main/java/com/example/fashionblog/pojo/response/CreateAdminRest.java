package com.example.fashionblog.pojo.response;

import com.example.fashionblog.enums.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateAdminRest {
    private  String userId;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}

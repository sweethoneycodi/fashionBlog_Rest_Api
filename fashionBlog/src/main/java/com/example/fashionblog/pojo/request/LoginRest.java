package com.example.fashionblog.pojo.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginRest {
    private String email;
    private String password;
}

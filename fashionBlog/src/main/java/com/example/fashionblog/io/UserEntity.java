package com.example.fashionblog.io;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
@Entity()
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false,length = 50)
    private String userId;

    @Column(nullable = false,length = 15)
    private String firstName;

    @Column(nullable = false,length = 15)
    private String lastName;

    @Column(nullable = false,length = 25)
    private String email;


    @Column(nullable = false)
    private String encryptedPassword;

    private String emailVerificationToken;

    @Column(nullable = false)
    private boolean emailVerificationStatus = false;
}

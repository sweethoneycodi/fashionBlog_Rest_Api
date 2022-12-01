package com.example.fashionblog.io;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "users")
@Getter
@Setter
public class AdminEntity {

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

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Post> posts;


    @Column(nullable = false)
    private String encryptedPassword;

    private String emailVerificationToken;

    @Column(nullable = false)
    private boolean emailVerificationStatus = false;
}

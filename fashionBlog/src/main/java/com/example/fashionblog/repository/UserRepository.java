package com.example.fashionblog.repository;

import com.example.fashionblog.io.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AdminEntity,Long> {
    Optional<AdminEntity> findByEmail(String email);
   // Optional<AdminEntity> findByEmailAAndEncryptedPassword(String email, String password);
}

package com.example.fashionblog.io;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private Post post;

    private boolean likeComment;

    @CreationTimestamp
    private LocalDateTime commentTime;
}

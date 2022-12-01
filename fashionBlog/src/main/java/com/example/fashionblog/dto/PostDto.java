package com.example.fashionblog.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Data
@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    @NotNull(message = "required")
    private String title;
    @NotNull(message = "required")
    private String description;
    @NotNull(message = "required")
    private String image;
    private LocalDateTime postTime;
    private LocalDateTime updateTime;
}

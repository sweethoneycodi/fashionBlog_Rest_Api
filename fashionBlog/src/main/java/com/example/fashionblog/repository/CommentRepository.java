package com.example.fashionblog.repository;

import com.example.fashionblog.io.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}

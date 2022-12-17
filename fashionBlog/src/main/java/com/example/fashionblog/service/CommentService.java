package com.example.fashionblog.service;

import com.example.fashionblog.dto.CommentDto;
import com.example.fashionblog.io.Comment;

import java.util.List;

public interface CommentService {

    CommentDto createComment(CommentDto comment, Long PostId);

    List<Comment> getAllPostComment(Long postId);

    String deleteComment(Long commentId);
}

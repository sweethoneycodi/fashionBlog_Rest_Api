package com.example.fashionblog.repository;

import com.example.fashionblog.io.Comment;
import com.example.fashionblog.io.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAllCommentByPost(Post post);


}

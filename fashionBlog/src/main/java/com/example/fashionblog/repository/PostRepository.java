package com.example.fashionblog.repository;

import com.example.fashionblog.io.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    boolean existsById(Long id);
    Optional<Post> findPostByTitle(String title);

}

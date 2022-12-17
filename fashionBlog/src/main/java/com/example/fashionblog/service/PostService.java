package com.example.fashionblog.service;

import com.example.fashionblog.dto.PostDto;
import com.example.fashionblog.io.Post;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto updatePost(PostDto postDto, Long id);
    PostDto getPost(String title);
    List<Post> getAllPost();
    String deletePost(Long id);
}

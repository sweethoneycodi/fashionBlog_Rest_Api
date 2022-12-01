package com.example.fashionblog.service;

import com.example.fashionblog.dto.PostDto;
import com.example.fashionblog.io.Post;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto updatePost(PostDto postDto);
    PostDto getPost(Long id);
    List<PostDto> getAllPost(PostDto postDto, Long id);
    void deletePost(Long id);
}

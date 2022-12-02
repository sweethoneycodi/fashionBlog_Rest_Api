package com.example.fashionblog.controllers;

import com.example.fashionblog.dto.PostDto;
import com.example.fashionblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PostController {

    private final PostService postServiceImp;

    @PostMapping("/createPost")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto post) {

        PostDto createdPost = postServiceImp.createPost(post);
        return new ResponseEntity<>(createdPost,HttpStatus.CREATED);
    }

    @PutMapping("/updatePost")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Long id) {
        PostDto returnValue = postServiceImp.updatePost(postDto,id);
        return new ResponseEntity<>(returnValue,HttpStatus.ACCEPTED);
    }
}

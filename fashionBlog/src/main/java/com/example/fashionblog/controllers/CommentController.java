package com.example.fashionblog.controllers;

import com.example.fashionblog.dto.CommentDto;
import com.example.fashionblog.io.Comment;
import com.example.fashionblog.repository.CommentRepository;
import com.example.fashionblog.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@AllArgsConstructor
public class CommentController {

    private final CommentService commentServiceImp;

    @PostMapping("/create")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Long postId) {
        CommentDto createComment = commentServiceImp.createComment(commentDto,postId);
        return new ResponseEntity<>(createComment, HttpStatus.CREATED);
    }

    @GetMapping("/allComments")
    public ResponseEntity<List<Comment>> getALlComment(@PathVariable Long id) {
        List<Comment> comments = commentServiceImp.getAllPostComment(id);
        return new ResponseEntity<>(comments,HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteComment")
    public ResponseEntity<String> deleteComment(@PathVariable Long id){
        String deletedComment = commentServiceImp.deleteComment(id);
        return new ResponseEntity<>(deletedComment,HttpStatus.OK);
    }
}

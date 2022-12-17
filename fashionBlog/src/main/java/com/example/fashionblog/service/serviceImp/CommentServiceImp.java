package com.example.fashionblog.service.serviceImp;

import com.example.fashionblog.dto.CommentDto;
import com.example.fashionblog.exception.exceptionLoader.CommentNotFoundException;
import com.example.fashionblog.exception.exceptionLoader.PostNotFoundException;
import com.example.fashionblog.exception.exceptionLoader.UserNotFoundException;
import com.example.fashionblog.io.Comment;
import com.example.fashionblog.io.Post;
import com.example.fashionblog.io.User;
import com.example.fashionblog.repository.CommentRepository;
import com.example.fashionblog.repository.PostRepository;
import com.example.fashionblog.repository.UserRepository;
import com.example.fashionblog.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CommentServiceImp implements CommentService {

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    @Override
    public CommentDto createComment(CommentDto comment, Long postId) {
        String text = comment.getText();
        Long userId = comment.getUserId();

        Post post = postRepository.findById(postId)
                .orElseThrow(()-> {
                    throw new PostNotFoundException("post with id"+ postId + "not found");
                });
        User user = userRepository.findById(userId)
                .orElseThrow(()->{
                    throw new UserNotFoundException("user with id " + userId + "not found");
                });

        Comment comment1 = new Comment();
        comment1.setText(text);
        comment1.setPost(post);
        comment1.setUser(user);

         commentRepository.save(comment1);

        return comment;
    }

    @Override
    public List<Comment> getAllPostComment(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()->{
                    throw new PostNotFoundException("not found");
                });

        return commentRepository.findAllCommentByPost(post);
    }

    @Override
    public String deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()->{
                    throw new CommentNotFoundException("comment not found");
                });
        commentRepository.delete(comment);
        return "deleted";
    }
}

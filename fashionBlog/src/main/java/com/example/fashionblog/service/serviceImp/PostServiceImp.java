package com.example.fashionblog.service.serviceImp;

import com.example.fashionblog.dto.PostDto;
import com.example.fashionblog.enums.Role;
import com.example.fashionblog.io.Post;
import com.example.fashionblog.io.UserEntity;
import com.example.fashionblog.repository.PostRepository;
import com.example.fashionblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostServiceImp implements PostService {

    private final PostRepository postRepository;


    @Override
    public PostDto createPost(PostDto postDto) {
        Post newPost = new Post();
        UserEntity user = new UserEntity();

        if(user.getRole() != Role.ADMIN) throw new RuntimeException("cannot post");

        newPost.setTitle(postDto.getTitle());
        newPost.setDescription(postDto.getDescription());
        newPost.setImage(postDto.getImage());
        newPost.setPostTime(LocalDateTime.now());

        Post storedPost = postRepository.save(newPost);

        PostDto returnPost = new PostDto();
        BeanUtils.copyProperties(storedPost,returnPost);
        return returnPost;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        Post update = new Post();
        boolean check = postRepository.existsById(id);
        if(!check) throw new RuntimeException("post does not exist");

        update.setTitle(postDto.getTitle());
        update.setDescription(postDto.getDescription());
        update.setImage(postDto.getImage());
        update.setUpdateTime(LocalDateTime.now());

        PostDto returnValue = new PostDto();
        BeanUtils.copyProperties(update,returnValue);

        return returnValue;
    }

    @Override
    public PostDto getPost(String title) {
        Optional<Post> post = postRepository.findPostByTitle(title);

     //   if(Post post = postRepository.findById(id).isEmpty()) throw new RuntimeException("not found");
      //  Optional<Post> post = postRepository.findById(id).isPresent();

        PostDto found = new PostDto();
        BeanUtils.copyProperties(post,found);
        return found;
    }

    @Override
    public List<PostDto> getAllPost(PostDto postDto, Long id) {
        List<Post> posts = postRepository.findAllPost();
        List<PostDto> allPosts = new ArrayList<>();
             posts
                     .forEach(post -> {PostDto postDto1 = new PostDto();
                     BeanUtils.copyProperties(post,postDto1);
                     allPosts.add(postDto1);});

        return allPosts;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}

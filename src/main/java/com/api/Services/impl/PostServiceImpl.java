package com.api.Services.impl;

import com.api.Entity.Post;
import com.api.Services.PostService;
import com.api.dto.PostDto;
import com.api.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

       private PostRepository postRepo;


    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post save = postRepo.save(post);

        PostDto dto = new PostDto();
        dto.setTitle(save.getTitle());
        dto.setDescription(save.getDescription());
        dto.setContent(save.getContent());

        return dto;
    }
}

package com.api.Services.impl;

import com.api.Entity.Post;
import com.api.Exception.ResourceNotFoundException;
import com.api.Services.PostService;
import com.api.dto.PostDto;
import com.api.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

       private PostRepository postRepo;


    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = mapToEntity(postDto);

        Post save = postRepo.save(post);

        PostDto dto = mapToDto(save);

        return dto;
    }

    @Override
    public PostDto getPostById(long id) {
       Post post = postRepo.findById(id).orElseThrow(
               ()-> new ResourceNotFoundException("Post Not Found With This Id :"+id) //supplier functional Interface
        );

        PostDto dto = new PostDto();
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        return dto;
    }

    @Override
    public List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {


        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo , pageSize , sort);
        Page<Post> pagePost = postRepo.findAll(pageable);
        List<Post> posts = pagePost.getContent();

        //using stream API to convert the post Entity object to PostDto object.....
        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dtos;
    }


    // create methods to convert the post Entity object to postDto Object?
  public   PostDto mapToDto(Post post){

        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        return dto;

    }

    // create methods to convert the postDto object to post Entity Object?

  public  Post mapToEntity(PostDto postDto){

        Post post = new Post();

        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

      return post;

  }
}

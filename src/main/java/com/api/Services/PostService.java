package com.api.Services;

import com.api.dto.PostDto;

import java.util.List;

public interface PostService {
     public PostDto createPost(PostDto postDto);

    public  PostDto getPostById(long id);

    public  List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
}

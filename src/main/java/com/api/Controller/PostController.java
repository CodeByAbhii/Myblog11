package com.api.Controller;

import com.api.Services.PostService;
import com.api.dto.PostDto;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog")
public class PostController {

    public PostController(PostService postService) {
        this.postService = postService;
    }

    private PostService postService;


    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return  new ResponseEntity<>("Record is saved", HttpStatus.CREATED);
    }

}

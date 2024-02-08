package com.api.Controller;

import com.api.Services.PostService;
import com.api.dto.PostDto;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasRole;

@RestController
@RequestMapping("/api/blog")
public class PostController {

// http://localhost:8080/api/blog

    private PostService postService;
    // create Constructor .... dependency ingection
    public PostController(PostService postService) {
        this.postService = postService;
    }




    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return  new ResponseEntity<>("Record is saved", HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<PostDto>getPostById(@RequestParam long id){
        PostDto postById = postService.getPostById(id);
        return  new ResponseEntity<>(postById , HttpStatus.OK);
    }

   // http://localhost:8080/api/blog?pageNo=0&pageSize=3&sortBy=title&sortDir=desc
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<PostDto> getALlPost(
            @RequestParam(name = "pageNo",required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize",required = false, defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy",required = false, defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDir",required = false, defaultValue = "id") String sortDir
    ){
       List<PostDto> postDto=  postService.getAllPost(pageNo , pageSize , sortBy , sortDir);
        return postDto;
    }

}

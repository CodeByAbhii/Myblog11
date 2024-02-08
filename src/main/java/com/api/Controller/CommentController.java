package com.api.Controller;


import com.api.Entity.Comment;
import com.api.Services.CommentService;
import com.api.dto.CommentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // http://localhost:8080/api/comments?postId=1
    @PostMapping
    public  ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto ,
            @RequestParam long postId
            ){

        CommentDto comment = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(comment , HttpStatus.CREATED);
    }


    //http://localhost:8080/api/comments/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteComment(@PathVariable long id){
        commentService.deleteById(id);
        return  new ResponseEntity<>("Comments is Deleted!!", HttpStatus.OK);
    }

    //http://localhost:8080/api/comments/1/post/1
    @PutMapping("/{id}/post/{postId}")
    public ResponseEntity<CommentDto>updateComment(
            @PathVariable long id ,
            @RequestBody CommentDto commentDto,
            @PathVariable long postId
    ){
        CommentDto dto = commentService.updateComment(id, commentDto , postId);
        return new ResponseEntity<>(dto , HttpStatus.OK);
    }




}

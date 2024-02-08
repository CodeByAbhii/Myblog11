package com.api.Services.impl;

import com.api.Entity.Comment;
import com.api.Entity.Post;
import com.api.Exception.ResourceNotFoundException;
import com.api.Services.CommentService;
import com.api.dto.CommentDto;
import com.api.repository.CommentRepository;
import com.api.repository.PostRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;


    private PostRepository postRepository;

    public CommentServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // ModelMapper is 3rd party libreay but
    // in Spring IOC have doesnot imformation of Modelmappar so create @Bean in main mathed after is useable in project
    private ModelMapper modelMapper;


    public CommentServiceImpl(CommentRepository commentRepository , ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper=modelMapper;
    }


    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(

                () -> new ResourceNotFoundException("Post Not Find this Id : " + postId)
        );

        Comment c = mapToEntity(commentDto);
        c.setId(post.getId());
        c.setPost(post);

        Comment saveComment = commentRepository.save(c);

        CommentDto dto = mapToDto(saveComment);


        return dto;
    }
    @Override
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto, long postId) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post Not Found With this Id : " + id)
        );

        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment Not Found With this Id : " + id)
        );


        Comment c = mapToEntity(commentDto);
        c.setId(comment.getId());

        c.setPost(post);
        Comment saved = commentRepository.save(c);

        CommentDto dto = mapToDto(saved);
        return  dto;

    }

    public CommentDto mapToDto(Comment  comment) {
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;
    }

     public Comment mapToEntity(CommentDto commentDto){
         Comment comment = modelMapper.map(commentDto , Comment.class);
         return comment;
        }

    }




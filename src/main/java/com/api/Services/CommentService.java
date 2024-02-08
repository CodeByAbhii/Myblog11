package com.api.Services;

import com.api.dto.CommentDto;

public interface CommentService {

    public CommentDto createComment(CommentDto commentDto , long postId);

   public void deleteById(long id);

   public CommentDto updateComment(long id, CommentDto commentDto, long postId);
}

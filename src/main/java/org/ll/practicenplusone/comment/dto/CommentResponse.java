package org.ll.practicenplusone.comment.dto;

import org.ll.practicenplusone.comment.entity.Comment;

public record CommentResponse(
        Long id,
        String content
) {
    public static CommentResponse from(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                comment.getContent()
        );
    }
}

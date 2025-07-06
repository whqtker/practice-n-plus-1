package org.ll.practicenplusone.post.dto;

import org.ll.practicenplusone.comment.dto.CommentResponse;
import org.ll.practicenplusone.post.entity.Post;

import java.util.List;

public record PostResponse(
        Long id,
        String title,
        String content,
        List<CommentResponse> comments
) {
    public static PostResponse from(Post post) {
        List<CommentResponse> commentResponses = post.getComments().stream()
                .map(CommentResponse::from)
                .toList();

        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                commentResponses
        );
    }
}

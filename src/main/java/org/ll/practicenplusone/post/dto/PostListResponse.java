package org.ll.practicenplusone.post.dto;

import java.util.List;

public record PostListResponse(
        List<PostResponse> posts
) {
    public static PostListResponse from(List<PostResponse> posts) {
        return new PostListResponse(posts);
    }
}

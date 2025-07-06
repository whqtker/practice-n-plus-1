package org.ll.practicenplusone.post.controller;

import lombok.RequiredArgsConstructor;
import org.ll.practicenplusone.post.entity.Post;
import org.ll.practicenplusone.post.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/posts")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}

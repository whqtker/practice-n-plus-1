package org.ll.practicenplusone.post.service;

import lombok.RequiredArgsConstructor;
import org.ll.practicenplusone.post.dto.PostListResponse;
import org.ll.practicenplusone.post.dto.PostResponse;
import org.ll.practicenplusone.post.entity.Post;
import org.ll.practicenplusone.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostListResponse getAllPosts() {
        // N+1 문제 발생
        // List<Post> posts = postRepository.findAll();

        // Fetch Join
        // List<Post> posts = postRepository.findAllWithComments();

        // Entity Graph
        // List<Post> posts = postRepository.findAll();

        // Batch Size
        List<Post> posts = postRepository.findAll();

        List<PostResponse> postResponses = posts.stream()
                .map(PostResponse::from)
                .toList();

        return PostListResponse.from(postResponses);
    }

    @Transactional
    public Post createPost(String title, String content) {
        Post post = new Post(title, content);

        return postRepository.save(post);
    }
}

package org.ll.practicenplusone.post.service;

import lombok.RequiredArgsConstructor;
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
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public Post createPost(String title, String content) {
        Post post = new Post(title, content);

        return postRepository.save(post);
    }
}

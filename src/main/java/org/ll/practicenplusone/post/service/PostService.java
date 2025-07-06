package org.ll.practicenplusone.post.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.ll.practicenplusone.post.dto.PostListResponse;
import org.ll.practicenplusone.post.dto.PostResponse;
import org.ll.practicenplusone.post.entity.Post;
import org.ll.practicenplusone.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Transactional(readOnly = true)
    public PostListResponse getAllPosts() {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        Statistics statistics = sessionFactory.getStatistics();
        statistics.clear();

        // N+1 문제 발생, Batch Size 사용 시 이 메서드 사용
        List<Post> posts = postRepository.findAll();

        log.info("===== 댓글 접근 전 쿼리 수: {} =====", statistics.getPrepareStatementCount());

        // Fetch Join
        // List<Post> posts = postRepository.findAllWithComments();

        // Entity Graph
        // List<Post> posts = postRepository.findAll();

        List<PostResponse> postResponses = posts.stream()
                .map(PostResponse::from)
                .toList();

        log.info("===== 댓글 접근 후 쿼리 수: {} =====", statistics.getPrepareStatementCount());

        return PostListResponse.from(postResponses);
    }

    @Transactional
    public Post createPost(String title, String content) {
        Post post = new Post(title, content);

        return postRepository.save(post);
    }
}

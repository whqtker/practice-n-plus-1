package org.ll.practicenplusone.global.initData;

import lombok.RequiredArgsConstructor;
import org.ll.practicenplusone.comment.service.CommentService;
import org.ll.practicenplusone.post.entity.Post;
import org.ll.practicenplusone.post.service.PostService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class InitData {

    private final PostService postService;
    private final CommentService commentService;

    @Bean
    public ApplicationRunner initDataRunner() {
        return args -> {
            initData();
        };
    }

    @Transactional
    public void initData() {
        // 게시글 10개 생성
        for (int i = 1; i <= 10; i++) {
            Post post = postService.createPost(
                    String.format("게시글 제목 %d", i),
                    String.format("게시글 내용 %d", i)
            );

            // 각 게시글마다 댓글 3개 생성
            for (int j = 1; j <= 3; j++) {
                commentService.createComment(
                        post,
                        String.format("게시글 %d - 댓글 %d", i, j)
                );
            }
        }
    }
}

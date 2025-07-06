package org.ll.practicenplusone.comment.service;

import lombok.RequiredArgsConstructor;
import org.ll.practicenplusone.comment.entity.Comment;
import org.ll.practicenplusone.comment.repository.CommentRepository;
import org.ll.practicenplusone.post.entity.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Comment createComment(Post post, String content) {
        Comment comment = new Comment(post, content);

        return commentRepository.save(comment);
    }
}

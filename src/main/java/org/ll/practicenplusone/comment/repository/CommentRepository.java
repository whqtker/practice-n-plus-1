package org.ll.practicenplusone.comment.repository;

import org.ll.practicenplusone.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

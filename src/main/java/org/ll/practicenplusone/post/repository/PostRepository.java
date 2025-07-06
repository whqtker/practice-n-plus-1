package org.ll.practicenplusone.post.repository;

import org.ll.practicenplusone.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

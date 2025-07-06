package org.ll.practicenplusone.post.repository;

import org.ll.practicenplusone.post.entity.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // Fetch Join
//    @Query("SELECT DISTINCT p FROM Post p LEFT JOIN FETCH p.comments")
//    List<Post> findAllWithComments();

    // Entity Graph
//    @Override
//    @EntityGraph(attributePaths = {"comments"})
//    List<Post> findAll();
}

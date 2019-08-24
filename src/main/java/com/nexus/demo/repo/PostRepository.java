package com.nexus.demo.repo;


import com.nexus.demo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByAuthor(String author);
    Post findPostById(Long id);
    Post findPostByTitle(String title);
}

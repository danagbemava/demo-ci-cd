package com.nexus.demo.services;

import com.nexus.demo.domain.BasicResponse;
import com.nexus.demo.models.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    BasicResponse addNewPost(Post post);
    BasicResponse deletePost(Long id);
    BasicResponse editPost(Post post);
    BasicResponse findPost(Long id);
    BasicResponse findAllPostsByAuthor(String author);
}

package com.nexus.demo.impl;

import com.nexus.demo.domain.BasicResponse;
import com.nexus.demo.models.Post;
import com.nexus.demo.repo.PostRepository;
import com.nexus.demo.services.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public BasicResponse addNewPost(Post post) {
        BasicResponse response = new BasicResponse();

        Post findPost = postRepository.findPostByTitle(post.getTitle());

        if(findPost != null) {
            response.setCode(400);
            response.setMessage("Post already exists");
            return response;
        }

        try{
            postRepository.save(post);
            response.setCode(200);
            response.setMessage("Post added successfully");
            return response;
        }catch (Exception ex) {
            response.setCode(500);
            response.setMessage("An unexpected error occurred");
            response.setObject(ex);
            return response;
        }
    }

    @Override
    public BasicResponse deletePost(Long id) {
        return null;
    }

    @Override
    public BasicResponse editPost(Post post) {
        return null;
    }

    @Override
    public BasicResponse findPost(Long id) {
        return null;
    }

    @Override
    public BasicResponse findAllPostsByAuthor(String author) {
        return null;
    }
}

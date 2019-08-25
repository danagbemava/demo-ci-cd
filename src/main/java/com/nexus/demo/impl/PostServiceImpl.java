package com.nexus.demo.impl;

import com.nexus.demo.domain.BasicResponse;
import com.nexus.demo.models.Post;
import com.nexus.demo.repo.PostRepository;
import com.nexus.demo.services.PostService;
import com.nexus.demo.utils.Constants;
import org.apache.tomcat.util.bcel.Const;
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
            response.setCode(Constants.OPERATION_SUCCESSFUL_CODE);
            response.setMessage(Constants.OPERATION_SUCCESSFUL_MSG);
            return response;
        }catch (Exception ex) {
            response.setCode(Constants.UNEXPECTED_ERROR_CODE);
            response.setMessage(Constants.UNEXPECTED_ERROR_MSG);
            response.setObject(ex);
            return response;
        }
    }

    @Override
    public BasicResponse deletePost(Long id) {
        BasicResponse response = new BasicResponse();

        Post findPost = postRepository.findPostById(id);

        if(findPost == null) {
            response.setMessage(Constants.ITEM_NOT_FOUND_MSG);
            response.setCode(Constants.ITEM_NOT_FOUND_CODE);
            return response;
        }


        try {
            postRepository.delete(findPost);
            response.setCode(Constants.OPERATION_SUCCESSFUL_CODE);
            response.setMessage(Constants.OPERATION_SUCCESSFUL_MSG);
        }catch (Exception ex) {
            response.setMessage(Constants.UNEXPECTED_ERROR_MSG);
            response.setCode(Constants.UNEXPECTED_ERROR_CODE);
            response.setObject(ex);
        }

        return response;
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

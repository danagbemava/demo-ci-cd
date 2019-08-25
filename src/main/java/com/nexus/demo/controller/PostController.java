package com.nexus.demo.controller;

import com.nexus.demo.domain.BasicResponse;
import com.nexus.demo.dtos.PostDTO;
import com.nexus.demo.models.Post;
import com.nexus.demo.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts/")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("addPost")
    public ResponseEntity<BasicResponse> addPost(@RequestBody PostDTO post) {
        logger.info("+===================== Beginning addPost =====================+");
        BasicResponse response;

        logger.info("Create a new post object from the DTO");
        Post newPost = new Post(post.getAuthor(), post.getTitle(), post.getComment());

        logger.info("get a response from the post service");
        response = postService.addNewPost(newPost);

        if(response.getCode() == 200) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}

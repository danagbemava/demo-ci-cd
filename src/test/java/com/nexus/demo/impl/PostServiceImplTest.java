package com.nexus.demo.impl;

import com.nexus.demo.controller.PostController;
import com.nexus.demo.domain.BasicResponse;
import com.nexus.demo.models.Post;
import com.nexus.demo.repo.PostRepository;
import com.nexus.demo.services.PostService;
import com.nexus.demo.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.Basic;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PostServiceImplTest {

    @InjectMocks
    private PostServiceImpl postService;

    @Mock
    private PostRepository postRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addNewPost() {
        Post post = new Post("Mark Twain", "Tom Sawyer", "Something special");
        post.setId(1L);

        BasicResponse response = postService.addNewPost(post);

        assertEquals(Constants.OPERATION_SUCCESSFUL_CODE, response.getCode());
    }

    @Test
    public void deletePost() {
        Long postId = 1L;

        BasicResponse response = postService.deletePost(postId);

        assertEquals(Constants.ITEM_NOT_FOUND_CODE, response.getCode());
    }
}
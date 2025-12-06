package edu.sias.service;

import edu.sias.entity.Post;
import edu.sias.dto.PostCreateDTO;

import java.util.List;

public interface PostService {
    Post createPost(PostCreateDTO postCreateDTO, Long userId);
    Post getPostById(Long id);
    List<Post> getPublishedPosts();
    List<Post> getUserPosts(Long userId);
    Post updatePostStatus(Long id, String status);
}
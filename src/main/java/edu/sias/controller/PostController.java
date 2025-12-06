package edu.sias.controller;

import edu.sias.common.ResponseResult;
import edu.sias.dto.PostCreateDTO;
import edu.sias.entity.Post;
import edu.sias.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    
    @Autowired
    private PostService postService;
    
    // 用户发布信息
    @PostMapping("/user/posts")
    public ResponseResult<Post> createPost(@RequestBody PostCreateDTO postCreateDTO) {
        try {
            // 这里简化处理，实际应该从Security Context中获取用户ID
            Long userId = 1L; 
            Post post = postService.createPost(postCreateDTO, userId);
            return ResponseResult.success(post);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
    
    // 获取公开信息列表
    @GetMapping("/public/posts")
    public ResponseResult<List<Post>> getPublishedPosts() {
        try {
            List<Post> posts = postService.getPublishedPosts();
            return ResponseResult.success(posts);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
    
    // 获取信息详情
    @GetMapping("/public/posts/{id}")
    public ResponseResult<Post> getPostById(@PathVariable Long id) {
        try {
            Post post = postService.getPostById(id);
            return ResponseResult.success(post);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
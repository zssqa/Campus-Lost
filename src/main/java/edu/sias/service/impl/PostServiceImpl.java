package edu.sias.service.impl;

import edu.sias.entity.Post;
import edu.sias.mapper.PostMapper;
import edu.sias.service.PostService;
import edu.sias.dto.PostCreateDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
    private PostMapper postMapper;
    
    @Override
    public Post createPost(PostCreateDTO postCreateDTO, Long userId) {
        Post post = new Post();
        BeanUtils.copyProperties(postCreateDTO, post);
        post.setUserId(userId);
        post.setStatus("PENDING"); // 默认状态为待审核
        post.setCreateTime(System.currentTimeMillis());
        post.setUpdateTime(System.currentTimeMillis());
        
        postMapper.insert(post);
        return post;
    }
    
    @Override
    public Post getPostById(Long id) {
        return postMapper.selectById(id);
    }
    
    @Override
    public List<Post> getPublishedPosts() {
        return postMapper.selectPublishedPosts();
    }
    
    @Override
    public List<Post> getUserPosts(Long userId) {
        return postMapper.selectByUserId(userId);
    }
    
    @Override
    public Post updatePostStatus(Long id, String status) {
        postMapper.updateStatus(id, status);
        return postMapper.selectById(id);
    }
}
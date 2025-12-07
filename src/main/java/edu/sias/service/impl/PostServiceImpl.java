package edu.sias.service.impl;

import edu.sias.entity.Post;
import edu.sias.mapper.PostMapper;
import edu.sias.service.PostService;
import edu.sias.dto.PostCreateDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 信息服务实现类
 * 实现信息相关的业务逻辑
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    /**
     * 创建失物/拾到信息实现
     * @param postCreateDTO 信息创建数据传输对象
     * @param userId 发布用户ID
     * @return 创建成功的信息对象
     */
    @Override
    public Post createPost(PostCreateDTO postCreateDTO, Long userId) {
        Post post = new Post();
        BeanUtils.copyProperties(postCreateDTO, post);
        post.setUserId(userId);
        post.setStatus("PENDING"); // 发布信息，设为待审核状态
        post.setCreateTime(System.currentTimeMillis());
        post.setUpdateTime(System.currentTimeMillis());
            
        postMapper.insert(post);
        return post;
    }

    /**
     * 根据ID获取信息详情实现
     * @param id 信息ID
     * @return 信息对象
     */
    @Override
    public Post getPostById(Long id) {
        return postMapper.selectById(id);
    }

    /**
     * 获取已发布的信息列表实现
     * @return 已发布的信息列表
     */
    @Override
    public List<Post> getPublishedPosts() {
        return postMapper.selectPublishedPosts();
    }

    /**
     * 获取指定用户发布的信息列表实现
     * @param userId 用户ID
     * @return 用户发布的信息列表
     */
    @Override
    public List<Post> getUserPosts(Long userId) {
        return postMapper.selectByUserId(userId);
    }

    /**
     * 更新信息状态实现
     * @param id 信息ID
     * @param status 信息状态
     * @return 更新后的信息对象
     */
    @Override
    public Post updatePostStatus(Long id, String status) {
        postMapper.updateStatus(id, status);
        return postMapper.selectById(id);
    }

    /**
     * 获取待审核的信息列表实现
     * @return 待审核的信息列表
     */
    @Override
    public List<Post> getPendingPosts() {
        return postMapper.selectByStatus("PENDING");
    }

    /**
     * 获取所有信息列表实现（用于管理）
     * @return 所有信息列表
     */
    @Override
    public List<Post> getAllPosts() {
        return postMapper.selectAllPosts();
    }

    /**
     * 删除信息实现
     * @param id 信息ID
     */
    @Override
    public void deletePost(Long id) {
        postMapper.deleteById(id);
    }

    /**
     * 更新审核原因实现
     * @param id 信息ID
     * @param reason 审核原因
     */
    @Override
    public void updateAuditReason(Long id, String reason) {
        postMapper.updateAuditReason(id, reason);
    }
}
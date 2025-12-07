package edu.sias.service;

import edu.sias.entity.Post;
import edu.sias.dto.PostCreateDTO;

import java.util.List;

/**
 * 信息服务接口
 * 定义信息相关的业务逻辑方法
 */
public interface PostService {
    
    /**
     * 创建失物/拾到信息
     * @param postCreateDTO 信息创建数据传输对象
     * @param userId 发布用户ID
     * @return 创建成功的信息对象
     */
    Post createPost(PostCreateDTO postCreateDTO, Long userId);
    
    /**
     * 根据ID获取信息详情
     * @param id 信息ID
     * @return 信息对象
     */
    Post getPostById(Long id);
    
    /**
     * 获取已发布的信息列表
     * @return 已发布的信息列表
     */
    List<Post> getPublishedPosts();
    
    /**
     * 获取指定用户发布的信息列表
     * @param userId 用户ID
     * @return 用户发布的信息列表
     */
    List<Post> getUserPosts(Long userId);
    
    /**
     * 更新信息状态
     * @param id 信息ID
     * @param status 信息状态
     * @return 更新后的信息对象
     */
    Post updatePostStatus(Long id, String status);
    
    /**
     * 获取待审核的信息列表
     * @return 待审核的信息列表
     */
    List<Post> getPendingPosts();
    
    /**
     * 获取所有信息列表（用于管理）
     * @return 所有信息列表
     */
    List<Post> getAllPosts();
    
    /**
     * 删除信息
     * @param id 信息ID
     */
    void deletePost(Long id);
    
    /**
     * 更新审核原因
     * @param id 信息ID
     * @param reason 审核原因
     */
    void updateAuditReason(Long id, String reason);
}
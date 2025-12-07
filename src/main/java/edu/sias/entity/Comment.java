package edu.sias.entity;

import lombok.Data;

/**
 * 评论实体类
 * 对应数据库中的comment表
 */
@Data
public class Comment {
    /** 评论ID，主键 */
    private Long id;
    
    /** 关联的信息ID，关联lost_found_post表 */
    private Long postId;
    
    /** 评论用户ID，关联user表 */
    private Long userId;
    
    /** 评论内容 */
    private String content;
    
    /** 父评论ID，用于回复功能 */
    private Long parentId;
    
    /** 创建时间，Unix时间戳格式 */
    private Long createTime;
    
    /** 是否已删除：0-未删除，1-已删除 */
    private Boolean deleted;
}
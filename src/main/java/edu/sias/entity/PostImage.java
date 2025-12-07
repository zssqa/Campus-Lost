package edu.sias.entity;

import lombok.Data;

/**
 * 信息图片实体类
 * 对应数据库中的post_image表
 */
@Data
public class PostImage {
    /** 图片ID，主键 */
    private Long id;
    
    /** 关联的信息ID，关联lost_found_post表 */
    private Long postId;
    
    /** 图片URL地址 */
    private String url;
    
    /** 排序字段 */
    private Integer sort;
    
    /** 创建时间，Unix时间戳格式 */
    private Long createTime;
}
package edu.sias.entity;

import lombok.Data;

/**
 * 失物/拾到信息实体类
 * 对应数据库中的lost_found_post表
 */
@Data
public class Post {
    /** 信息ID，主键 */
    private Long id;
    
    /** 信息类型：LOST-丢失，FOUND-拾到 */
    private String type;
    
    /** 信息标题 */
    private String title;
    
    /** 分类ID，关联category表 */
    private Long categoryId;
    
    /** 标签，多个标签用逗号分隔 */
    private String tags;
    
    /** 详细内容描述 */
    private String content;
    
    /** 发生时间，Unix时间戳格式 */
    private Long happenTime;
    
    /** 地点文本描述 */
    private String locationText;
    
    /** 纬度坐标 */
    private Double lat;
    
    /** 经度坐标 */
    private Double lng;
    
    /** 信息状态：PENDING-待审核，PUBLISHED-已发布，REJECTED-已拒绝，OFFLINE-已下架，RESOLVED-已解决 */
    private String status;
    
    /** 发布用户ID，关联user表 */
    private Long userId;
    
    /** 审核原因 */
    private String auditReason;
    
    /** 创建时间，Unix时间戳格式 */
    private Long createTime;
    
    /** 更新时间，Unix时间戳格式 */
    private Long updateTime;
    
    /** 是否匿名发布：true-匿名，false-实名 */
    private Boolean anonymous = false;
}
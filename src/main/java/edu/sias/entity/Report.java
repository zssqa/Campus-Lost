package edu.sias.entity;

import lombok.Data;

/**
 * 举报实体类
 * 对应数据库中的report表
 */
@Data
public class Report {
    /** 举报ID，主键 */
    private Long id;
    
    /** 关联的信息ID，关联lost_found_post表 */
    private Long postId;
    
    /** 举报用户ID，关联user表 */
    private Long reporterId;
    
    /** 举报原因 */
    private String reason;
    
    /** 举报详情 */
    private String detail;
    
    /** 举报状态：PENDING-待处理，PROCESSED-已处理，REJECTED-已拒绝 */
    private String status;
    
    /** 处理人ID，关联user表（管理员） */
    private Long handlerId;
    
    /** 处理结果 */
    private String handleResult;
    
    /** 处理备注 */
    private String handleNote;
    
    /** 创建时间，Unix时间戳格式 */
    private Long createTime;
    
    /** 处理时间，Unix时间戳格式 */
    private Long handleTime;
}
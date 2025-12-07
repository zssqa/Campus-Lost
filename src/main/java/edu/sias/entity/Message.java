package edu.sias.entity;

import lombok.Data;

/**
 * 站内信实体类
 * 对应数据库中的message表
 */
@Data
public class Message {
    /** 消息ID，主键 */
    private Long id;
    
    /** 发送用户ID，关联user表 */
    private Long fromUser;
    
    /** 接收用户ID，关联user表 */
    private Long toUser;
    
    /** 消息内容 */
    private String content;
    
    /** 创建时间，Unix时间戳格式 */
    private Long createTime;
    
    /** 是否已读：0-未读，1-已读 */
    private Boolean readFlag;
}
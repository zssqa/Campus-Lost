package edu.sias.entity;

import lombok.Data;

/**
 * 用户实体类
 * 对应数据库中的user表
 */
@Data
public class User {
    /** 用户ID，主键 */
    private Long id;
    
    /** 用户账号，唯一标识 */
    private String account;
    
    /** 用户密码 */
    private String password;
    
    /** 用户昵称 */
    private String nickname;
    
    /** 用户角色：USER-普通用户，ADMIN-管理员 */
    private String role;
    
    /** 用户状态：NORMAL-正常，BANNED-禁用 */
    private String status;
    
    /** 创建时间，Unix时间戳格式 */
    private Long createTime;
}
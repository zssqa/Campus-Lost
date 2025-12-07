package edu.sias.dto;

import lombok.Data;

/**
 * 用户登录数据传输对象
 * 用于接收用户登录时提交的数据
 */
@Data
public class UserLoginDTO {
    /** 用户账号 */
    private String account;
    
    /** 用户密码 */
    private String password;
}
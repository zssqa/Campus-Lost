package edu.sias.dto;

import lombok.Data;

/**
 * 用户注册数据传输对象
 * 用于接收用户注册时提交的数据
 */
@Data
public class UserRegisterDTO {
    /** 用户账号 */
    private String account;
    
    /** 用户密码 */
    private String password;
    
    /** 用户昵称 */
    private String nickname;
}
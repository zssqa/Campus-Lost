package edu.sias.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String account;
    private String password;
    private String nickname;
    private String role; // USER, ADMIN
    private String status; // NORMAL, BANNED
    private Long createTime;
}
package edu.sias.entity;

import lombok.Data;

@Data
public class Message {
    private Long id;
    private Long fromUser;
    private Long toUser;
    private String content;
    private Long createTime;
    private Boolean readFlag;
}
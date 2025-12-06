package edu.sias.entity;

import lombok.Data;

@Data
public class Comment {
    private Long id;
    private Long postId;
    private Long userId;
    private String content;
    private Long parentId;
    private Long createTime;
    private Boolean deleted;
}
package edu.sias.entity;

import lombok.Data;

@Data
public class PostImage {
    private Long id;
    private Long postId;
    private String url;
    private Integer sort;
    private Long createTime;
}
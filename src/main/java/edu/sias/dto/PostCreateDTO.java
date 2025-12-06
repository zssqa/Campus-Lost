package edu.sias.dto;

import lombok.Data;

@Data
public class PostCreateDTO {
    private String type; // LOST, FOUND
    private String title;
    private Long categoryId;
    private String tags;
    private String content;
    private Long happenTime;
    private String locationText;
    private Double lat;
    private Double lng;
    private Boolean anonymous; // 是否匿名
}
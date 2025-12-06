package edu.sias.entity;

import lombok.Data;

@Data
public class Post {
    private Long id;
    private String type; // LOST, FOUND
    private String title;
    private Long categoryId;
    private String tags;
    private String content;
    private Long happenTime;
    private String locationText;
    private Double lat;
    private Double lng;
    private String status; // PENDING, PUBLISHED, REJECTED, OFFLINE, RESOLVED
    private Long userId;
    private String auditReason;
    private Long createTime;
    private Long updateTime;
}
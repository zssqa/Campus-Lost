package edu.sias.entity;

import lombok.Data;

@Data
public class Report {
    private Long id;
    private Long postId;
    private Long reporterId;
    private String reason;
    private String detail;
    private String status; // PENDING, PROCESSED, REJECTED
    private Long handlerId;
    private String handleResult;
    private String handleNote;
    private Long createTime;
    private Long handleTime;
}
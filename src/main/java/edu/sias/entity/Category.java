package edu.sias.entity;

import lombok.Data;

@Data
public class Category {
    private Long id;
    private String name;
    private String description;
    private Integer sort;
    private Long createTime;
}
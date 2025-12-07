package edu.sias.entity;

import lombok.Data;

/**
 * 分类实体类
 * 对应数据库中的category表
 */
@Data
public class Category {
    /** 分类ID，主键 */
    private Long id;
    
    /** 分类名称 */
    private String name;
    
    /** 分类描述 */
    private String description;
    
    /** 排序字段 */
    private Integer sort;
    
    /** 创建时间，Unix时间戳格式 */
    private Long createTime;
}
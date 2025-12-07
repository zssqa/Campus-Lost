package edu.sias.dto;

import lombok.Data;

/**
 * 信息发布数据传输对象
 * 用于接收用户发布信息时提交的数据
 */
@Data
public class PostCreateDTO {
    /** 信息类型：LOST-丢失，FOUND-拾到 */
    private String type;
    
    /** 信息标题 */
    private String title;
    
    /** 分类ID */
    private Long categoryId;
    
    /** 标签，多个标签用逗号分隔 */
    private String tags;
    
    /** 详细内容描述 */
    private String content;
    
    /** 发生时间，Unix时间戳格式 */
    private Long happenTime;
    
    /** 地点文本描述 */
    private String locationText;
    
    /** 纬度坐标 */
    private Double lat;
    
    /** 经度坐标 */
    private Double lng;
    
    /** 是否匿名发布：true-匿名，false-实名 */
    private Boolean anonymous;
}
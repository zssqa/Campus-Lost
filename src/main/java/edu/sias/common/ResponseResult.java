package edu.sias.common;

import lombok.Data;

/**
 * 统一响应结果封装类
 * 用于统一API接口的返回格式
 * @param <T> 返回数据的类型
 */
@Data
public class ResponseResult<T> {
    /** 状态码：200-成功，500-失败 */
    private Integer code;
    
    /** 响应消息 */
    private String message;
    
    /** 响应数据 */
    private T data;

    public ResponseResult() {}

    public ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功响应
     * @param data 响应数据
     * @return ResponseResult对象
     * @param <T> 数据类型
     */
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(200, "success", data);
    }

    /**
     * 错误响应
     * @param message 错误消息
     * @return ResponseResult对象
     * @param <T> 数据类型
     */
    public static <T> ResponseResult<T> error(String message) {
        return new ResponseResult<>(500, message, null);
    }
}
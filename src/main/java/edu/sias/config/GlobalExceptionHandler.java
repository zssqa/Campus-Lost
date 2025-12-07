package edu.sias.config;

import edu.sias.common.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * 统一处理系统中未捕获的异常
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    /**
     * 处理Exception异常
     * @param e 异常对象
     * @return 错误响应结果
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult<String> handleException(Exception e) {
        e.printStackTrace();
        return ResponseResult.error("系统错误：" + e.getMessage());
    }
    
    /**
     * 处理RuntimeException异常
     * @param e 运行时异常对象
     * @return 错误响应结果
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult<String> handleRuntimeException(RuntimeException e) {
        return ResponseResult.error(e.getMessage());
    }
}
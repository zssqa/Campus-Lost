package edu.sias.controller;

import edu.sias.common.ResponseResult;
import edu.sias.dto.UserLoginDTO;
import edu.sias.dto.UserRegisterDTO;
import edu.sias.entity.User;
import edu.sias.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 认证控制器
 * 处理用户注册和登录相关的HTTP请求
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    /**
     * 用户注册接口
     * @param userRegisterDTO 用户注册信息
     * @return 注册结果
     */
    @PostMapping("/register")
    public ResponseResult<User> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        try {
            User user = userService.register(userRegisterDTO);
            return ResponseResult.success(user);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
    
    /**
     * 用户登录接口
     * @param userLoginDTO 用户登录信息
     * @return 登录结果
     */
    @PostMapping("/login")
    public ResponseResult<User> login(@RequestBody UserLoginDTO userLoginDTO) {
        try {
            User user = userService.login(userLoginDTO);
            return ResponseResult.success(user);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
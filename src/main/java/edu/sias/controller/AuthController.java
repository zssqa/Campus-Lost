package edu.sias.controller;

import edu.sias.common.ResponseResult;
import edu.sias.dto.UserLoginDTO;
import edu.sias.dto.UserRegisterDTO;
import edu.sias.entity.User;
import edu.sias.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public ResponseResult<User> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        try {
            User user = userService.register(userRegisterDTO);
            return ResponseResult.success(user);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
    
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
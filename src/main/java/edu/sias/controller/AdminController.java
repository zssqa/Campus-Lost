package edu.sias.controller;

import edu.sias.common.ResponseResult;
import edu.sias.dto.UserLoginDTO;
import edu.sias.entity.Post;
import edu.sias.entity.User;
import edu.sias.service.PostService;
import edu.sias.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理员控制器
 * 处理管理员相关的HTTP请求
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private PostService postService;
    
    /**
     * 管理员登录接口
     * @param userLoginDTO 管理员登录信息
     * @return 登录结果
     */
    @PostMapping("/login")
    public ResponseResult<User> adminLogin(@RequestBody UserLoginDTO userLoginDTO) {
        try {
            User user = userService.login(userLoginDTO);
            // 检查是否为管理员
            if (!"ADMIN".equals(user.getRole())) {
                return ResponseResult.error("只有管理员才能登录管理后台");
            }
            return ResponseResult.success(user);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
    
    /**
     * 获取所有用户接口
     * @return 用户列表
     */
    @GetMapping("/users")
    public ResponseResult<List<User>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return ResponseResult.success(users);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
    
    /**
     * 禁用/启用用户接口
     * @param id 用户ID
     * @param status 用户状态：NORMAL-正常，BANNED-禁用
     * @return 更新结果
     */
    @PostMapping("/users/{id}/status")
    public ResponseResult<User> updateUserStatus(@PathVariable Long id, @RequestParam String status) {
        try {
            User user = userService.updateUserStatus(id, status);
            return ResponseResult.success(user);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
    
    /**
     * 获取待审核的信息接口
     * @return 待审核的信息列表
     */
    @GetMapping("/posts/pending")
    public ResponseResult<List<Post>> getPendingPosts() {
        try {
            List<Post> posts = postService.getPendingPosts();
            return ResponseResult.success(posts);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
    
    /**
     * 审核信息（批准或拒绝）接口
     * @param id 信息ID
     * @param status 审核状态：PUBLISHED-批准，REJECTED-拒绝
     * @param reason 拒绝原因（可选）
     * @return 审核结果
     */
    @PostMapping("/posts/{id}/audit")
    public ResponseResult<Post> auditPost(@PathVariable Long id, 
                                         @RequestParam String status, 
                                         @RequestParam(required = false) String reason) {
        try {
            Post post = postService.updatePostStatus(id, status);
            if ("REJECTED".equals(status) && reason != null) {
                postService.updateAuditReason(id, reason);
            }
            return ResponseResult.success(post);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
    
    /**
     * 获取所有信息接口（用于管理）
     * @return 所有信息列表
     */
    @GetMapping("/posts")
    public ResponseResult<List<Post>> getAllPosts() {
        try {
            List<Post> posts = postService.getAllPosts();
            return ResponseResult.success(posts);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
    
    /**
     * 删除信息接口
     * @param id 信息ID
     * @return 删除结果
     */
    @DeleteMapping("/posts/{id}")
    public ResponseResult<String> deletePost(@PathVariable Long id) {
        try {
            postService.deletePost(id);
            return ResponseResult.success("删除成功");
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
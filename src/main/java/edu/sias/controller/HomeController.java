package edu.sias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面路由控制器
 * 处理页面跳转相关的HTTP请求
 */
@Controller
public class HomeController {

    /**
     * 首页路由
     * @param model 视图模型
     * @return 首页视图名称
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "校园失物招领平台");
        return "index";
    }

    /**
     * 登录页面路由
     * @return 登录页面视图名称
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 注册页面路由
     * @return 注册页面视图名称
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 信息列表页面路由
     * @return 信息列表页面视图名称
     */
    @GetMapping("/posts")
    public String posts() {
        return "posts";
    }

    /**
     * 发布信息页面路由
     * @return 发布信息页面视图名称
     */
    @GetMapping("/post/create")
    public String createPost() {
        return "create-post";
    }

    /**
     * 管理员仪表板页面路由
     * @return 管理员仪表板页面视图名称
     */
    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin/dashboard";
    }
        
    /**
     * 管理员登录页面路由
     * @return 管理员登录页面视图名称
     */
    @GetMapping("/admin/login")
    public String adminLogin() {
        return "admin/login";
    }
        
    /**
     * 管理员用户管理页面路由
     * @return 管理员用户管理页面视图名称
     */
    @GetMapping("/admin/users")
    public String adminUsers() {
        return "admin/users";
    }
        
    /**
     * 管理员信息管理页面路由
     * @return 管理员信息管理页面视图名称
     */
    @GetMapping("/admin/posts")
    public String adminPosts() {
        return "admin/posts";
    }
}
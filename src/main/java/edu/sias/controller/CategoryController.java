package edu.sias.controller;

import edu.sias.common.ResponseResult;
import edu.sias.entity.Category;
import edu.sias.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 分类控制器
 * 处理分类相关的HTTP请求
 */
@RestController
@RequestMapping("/api/public")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    /**
     * 获取所有分类接口
     * @return 分类列表
     */
    @GetMapping("/categories")
    public ResponseResult<List<Category>> getAllCategories() {
        try {
            List<Category> categories = categoryService.getAllCategories();
            return ResponseResult.success(categories);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
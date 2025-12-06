package edu.sias.controller;

import edu.sias.common.ResponseResult;
import edu.sias.entity.Category;
import edu.sias.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
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
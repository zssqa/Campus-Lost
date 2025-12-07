package edu.sias.service;

import edu.sias.entity.Category;

import java.util.List;

/**
 * 分类服务接口
 * 定义分类相关的业务逻辑方法
 */
public interface CategoryService {
    
    /**
     * 获取所有分类列表
     * @return 分类列表
     */
    List<Category> getAllCategories();
    
    /**
     * 根据ID获取分类信息
     * @param id 分类ID
     * @return 分类对象
     */
    Category getCategoryById(Long id);
}
package edu.sias.service.impl;

import edu.sias.entity.Category;
import edu.sias.mapper.CategoryMapper;
import edu.sias.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类服务实现类
 * 实现分类相关的业务逻辑
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryMapper categoryMapper;
    
    /**
     * 获取所有分类列表实现
     * @return 分类列表
     */
    @Override
    public List<Category> getAllCategories() {
        return categoryMapper.selectAll();
    }
    
    /**
     * 根据ID获取分类信息实现
     * @param id 分类ID
     * @return 分类对象
     */
    @Override
    public Category getCategoryById(Long id) {
        return categoryMapper.selectById(id);
    }
}
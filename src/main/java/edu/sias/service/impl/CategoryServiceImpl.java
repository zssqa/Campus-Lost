package edu.sias.service.impl;

import edu.sias.entity.Category;
import edu.sias.mapper.CategoryMapper;
import edu.sias.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryMapper categoryMapper;
    
    @Override
    public List<Category> getAllCategories() {
        return categoryMapper.selectAll();
    }
    
    @Override
    public Category getCategoryById(Long id) {
        return categoryMapper.selectById(id);
    }
}
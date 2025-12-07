package edu.sias.mapper;

import edu.sias.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 分类Mapper接口
 * 定义分类相关的数据库操作方法
 */
@Mapper
public interface CategoryMapper {
    
    /**
     * 查询所有分类
     * @return 分类列表
     */
    @Select("SELECT * FROM category")
    List<Category> selectAll();
    
    /**
     * 根据ID查询分类
     * @param id 分类ID
     * @return 分类对象
     */
    @Select("SELECT * FROM category WHERE id = #{id}")
    Category selectById(Long id);
    
    /**
     * 插入分类记录
     * @param category 分类对象
     * @return 影响的行数
     */
    @Insert("INSERT INTO category(name, description, sort, create_time) " +
            "VALUES(#{name}, #{description}, #{sort}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Category category);
    
    /**
     * 更新分类记录
     * @param category 分类对象
     * @return 影响的行数
     */
    @Update("UPDATE category SET name = #{name}, description = #{description} WHERE id = #{id}")
    int update(Category category);
    
    /**
     * 根据ID删除分类
     * @param id 分类ID
     * @return 影响的行数
     */
    @Delete("DELETE FROM category WHERE id = #{id}")
    int deleteById(Long id);
}
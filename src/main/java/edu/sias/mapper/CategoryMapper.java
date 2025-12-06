package edu.sias.mapper;

import edu.sias.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    
    @Select("SELECT * FROM category")
    List<Category> selectAll();
    
    @Select("SELECT * FROM category WHERE id = #{id}")
    Category selectById(Long id);
    
    @Insert("INSERT INTO category(name, description, sort, create_time) " +
            "VALUES(#{name}, #{description}, #{sort}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Category category);
    
    @Update("UPDATE category SET name = #{name}, description = #{description} WHERE id = #{id}")
    int update(Category category);
    
    @Delete("DELETE FROM category WHERE id = #{id}")
    int deleteById(Long id);
}
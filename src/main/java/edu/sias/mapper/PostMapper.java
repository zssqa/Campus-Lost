package edu.sias.mapper;

import edu.sias.entity.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {
    
    @Select("SELECT * FROM lost_found_post WHERE id = #{id}")
    Post selectById(Long id);
    
    @Insert("INSERT INTO lost_found_post(type, title, category_id, tags, content, happen_time, location_text, " +
            "lat, lng, status, user_id, audit_reason, create_time, update_time) " +
            "VALUES(#{type}, #{title}, #{categoryId}, #{tags}, #{content}, #{happenTime}, #{locationText}, " +
            "#{lat}, #{lng}, #{status}, #{userId}, #{auditReason}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Post post);
    
    @Update("UPDATE lost_found_post SET title = #{title}, content = #{content}, update_time = #{updateTime} WHERE id = #{id}")
    int update(Post post);
    
    @Delete("DELETE FROM lost_found_post WHERE id = #{id}")
    int deleteById(Long id);
    
    @Select("SELECT * FROM lost_found_post WHERE status = 'PUBLISHED' ORDER BY create_time DESC")
    List<Post> selectPublishedPosts();
    
    @Select("SELECT * FROM lost_found_post WHERE user_id = #{userId} ORDER BY create_time DESC")
    List<Post> selectByUserId(Long userId);
    
    @Update("UPDATE lost_found_post SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") Long id, @Param("status") String status);
}
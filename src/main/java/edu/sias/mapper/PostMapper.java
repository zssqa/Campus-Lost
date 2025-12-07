package edu.sias.mapper;

import edu.sias.entity.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 信息Mapper接口
 * 定义失物/拾到信息相关的数据库操作方法
 */
@Mapper
public interface PostMapper {

    /**
     * 根据ID查询信息
     * @param id 信息ID
     * @return 信息对象
     */
    @Select("SELECT * FROM lost_found_post WHERE id = #{id}")
    Post selectById(Long id);

    /**
     * 插入信息记录
     * @param post 信息对象
     * @return 影响的行数
     */
    @Insert("INSERT INTO lost_found_post(type, title, category_id, tags, content, happen_time, location_text, " +
            "lat, lng, status, user_id, audit_reason, create_time, update_time, anonymous) " +
            "VALUES(#{type}, #{title}, #{categoryId}, #{tags}, #{content}, #{happenTime}, #{locationText}, " +
            "#{lat}, #{lng}, #{status}, #{userId}, #{auditReason}, #{createTime}, #{updateTime}, #{anonymous})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Post post);

    /**
     * 更新信息
     * @param post 信息对象
     * @return 影响的行数
     */
    @Update("UPDATE lost_found_post SET title = #{title}, content = #{content}, update_time = #{updateTime} WHERE id = #{id}")
    int update(Post post);

    /**
     * 根据ID删除信息
     * @param id 信息ID
     * @return 影响的行数
     */
    @Delete("DELETE FROM lost_found_post WHERE id = #{id}")
    int deleteById(Long id);

    /**
     * 查询已发布的信息列表
     * @return 已发布的信息列表
     */
    @Select("SELECT * FROM lost_found_post WHERE status = 'PUBLISHED' ORDER BY create_time DESC")
    List<Post> selectPublishedPosts();

    /**
     * 根据用户ID查询信息列表
     * @param userId 用户ID
     * @return 用户发布的信息列表
     */
    @Select("SELECT * FROM lost_found_post WHERE user_id = #{userId} ORDER BY create_time DESC")
    List<Post> selectByUserId(Long userId);

    /**
     * 更新信息状态
     * @param id 信息ID
     * @param status 信息状态
     * @return 影响的行数
     */
    @Update("UPDATE lost_found_post SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") Long id, @Param("status") String status);

    /**
     * 根据状态查询信息列表
     * @param status 信息状态
     * @return 指定状态的信息列表
     */
    @Select("SELECT * FROM lost_found_post WHERE status = #{status} ORDER BY id DESC")
    List<Post> selectByStatus(@Param("status") String status);
        
    /**
     * 查询所有信息列表
     * @return 所有信息列表
     */
    @Select("SELECT * FROM lost_found_post ORDER BY id DESC")
    List<Post> selectAllPosts();

    /**
     * 更新审核原因
     * @param id 信息ID
     * @param reason 审核原因
     * @return 影响的行数
     */
    @Update("UPDATE lost_found_post SET audit_reason = #{reason} WHERE id = #{id}")
    int updateAuditReason(@Param("id") Long id, @Param("reason") String reason);
}
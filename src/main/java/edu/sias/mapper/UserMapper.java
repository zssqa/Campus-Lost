package edu.sias.mapper;

import edu.sias.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户Mapper接口
 * 定义用户相关的数据库操作方法
 */
@Mapper
public interface UserMapper {
    
    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return 用户对象
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectById(Long id);
    
    /**
     * 根据账号查询用户
     * @param account 用户账号
     * @return 用户对象
     */
    @Select("SELECT * FROM user WHERE account = #{account}")
    User selectByAccount(String account);
    
    /**
     * 插入用户记录
     * @param user 用户对象
     * @return 影响的行数
     */
    @Insert("INSERT INTO user(account, password, nickname, role, status, create_time) " +
            "VALUES(#{account}, #{password}, #{nickname}, #{role}, #{status}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);
    
    /**
     * 更新用户昵称
     * @param id 用户ID
     * @param nickname 新昵称
     * @return 影响的行数
     */
    @Update("UPDATE user SET nickname = #{nickname} WHERE id = #{id}")
    int updateNickname(@Param("id") Long id, @Param("nickname") String nickname);
    
    /**
     * 更新用户状态
     * @param id 用户ID
     * @param status 用户状态
     * @return 影响的行数
     */
    @Update("UPDATE user SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") Long id, @Param("status") String status);
    
    /**
     * 查询所有用户
     * @return 用户列表
     */
    @Select("SELECT * FROM user")
    List<User> selectAll();
}
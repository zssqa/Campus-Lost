package edu.sias.mapper;

import edu.sias.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    
    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectById(Long id);
    
    @Select("SELECT * FROM user WHERE account = #{account}")
    User selectByAccount(String account);
    
    @Insert("INSERT INTO user(account, password, nickname, role, status, create_time) " +
            "VALUES(#{account}, #{password}, #{nickname}, #{role}, #{status}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);
    
    @Update("UPDATE user SET nickname = #{nickname} WHERE id = #{id}")
    int updateNickname(@Param("id") Long id, @Param("nickname") String nickname);
    
    @Select("SELECT * FROM user")
    List<User> selectAll();
}
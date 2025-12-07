package edu.sias.service;

import edu.sias.entity.User;
import edu.sias.dto.UserRegisterDTO;
import edu.sias.dto.UserLoginDTO;

import java.util.List;

/**
 * 用户服务接口
 * 定义用户相关的业务逻辑方法
 */
public interface UserService {
    
    /**
     * 用户注册
     * @param userRegisterDTO 用户注册信息传输对象
     * @return 注册成功的用户对象
     * @throws RuntimeException 当账号已存在时抛出异常
     */
    User register(UserRegisterDTO userRegisterDTO);
    
    /**
     * 用户登录
     * @param userLoginDTO 用户登录信息传输对象
     * @return 登录成功的用户对象
     * @throws RuntimeException 当账号不存在或密码错误或账号被禁用时抛出异常
     */
    User login(UserLoginDTO userLoginDTO);
    
    /**
     * 根据ID获取用户信息
     * @param id 用户ID
     * @return 用户对象，如果不存在则返回null
     */
    User getUserById(Long id);
    
    /**
     * 获取所有用户列表
     * @return 用户列表
     */
    List<User> getAllUsers();
    
    /**
     * 更新用户状态
     * @param id 用户ID
     * @param status 用户状态：NORMAL-正常，BANNED-禁用
     * @return 更新后的用户对象
     */
    User updateUserStatus(Long id, String status);
}
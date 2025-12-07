package edu.sias.service.impl;

import edu.sias.entity.User;
import edu.sias.mapper.UserMapper;
import edu.sias.service.UserService;
import edu.sias.dto.UserRegisterDTO;
import edu.sias.dto.UserLoginDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 * 实现用户相关的业务逻辑
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    /**
     * 用户注册实现
     * @param userRegisterDTO 用户注册信息传输对象
     * @return 注册成功的用户对象
     * @throws RuntimeException 当账号已存在时抛出异常
     */
    @Override
    public User register(UserRegisterDTO userRegisterDTO) {
        // 检查账号是否已存在
        User existingUser = userMapper.selectByAccount(userRegisterDTO.getAccount());
        if (existingUser != null) {
            throw new RuntimeException("账号已存在");
        }
        
        // 创建新用户
        User user = new User();
        BeanUtils.copyProperties(userRegisterDTO, user);
        // 不再进行密码加密处理，直接存储原始密码
        user.setRole("USER"); // 默认角色
        user.setStatus("NORMAL"); // 默认状态
        user.setCreateTime(System.currentTimeMillis());
        
        userMapper.insert(user);
        return user;
    }
    
    /**
     * 用户登录实现
     * @param userLoginDTO 用户登录信息传输对象
     * @return 登录成功的用户对象
     * @throws RuntimeException 当账号不存在或密码错误或账号被禁用时抛出异常
     */
    @Override
    public User login(UserLoginDTO userLoginDTO) {
        User user = userMapper.selectByAccount(userLoginDTO.getAccount());
        if (user == null) {
            throw new RuntimeException("账号不存在");
        }
        
        // 直接比较密码，不再解密
        if (!userLoginDTO.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        
        if (!"NORMAL".equals(user.getStatus())) {
            throw new RuntimeException("账号已被禁用");
        }
        
        return user;
    }
    
    /**
     * 根据ID获取用户信息实现
     * @param id 用户ID
     * @return 用户对象，如果不存在则返回null
     */
    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }
    
    /**
     * 获取所有用户列表实现
     * @return 用户列表
     */
    @Override
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }
    
    /**
     * 更新用户状态实现
     * @param id 用户ID
     * @param status 用户状态：NORMAL-正常，BANNED-禁用
     * @return 更新后的用户对象
     */
    @Override
    public User updateUserStatus(Long id, String status) {
        userMapper.updateStatus(id, status);
        return userMapper.selectById(id);
    }
}
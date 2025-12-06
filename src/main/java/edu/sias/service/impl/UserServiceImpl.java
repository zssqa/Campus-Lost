package edu.sias.service.impl;

import edu.sias.entity.User;
import edu.sias.mapper.UserMapper;
import edu.sias.service.UserService;
import edu.sias.dto.UserRegisterDTO;
import edu.sias.dto.UserLoginDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    
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
        user.setRole("USER"); // 默认角色
        user.setStatus("NORMAL"); // 默认状态
        user.setCreateTime(System.currentTimeMillis());

        
        userMapper.insert(user);
        return user;
    }
    
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
    
    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }
}
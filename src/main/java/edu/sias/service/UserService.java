package edu.sias.service;

import edu.sias.entity.User;
import edu.sias.dto.UserRegisterDTO;
import edu.sias.dto.UserLoginDTO;

public interface UserService {
    User register(UserRegisterDTO userRegisterDTO);
    User login(UserLoginDTO userLoginDTO);
    User getUserById(Long id);
}
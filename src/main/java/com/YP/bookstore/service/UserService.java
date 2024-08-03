package com.YP.bookstore.service;

import com.YP.bookstore.model.User;
import com.YP.bookstore.entity.UserDto;

public interface UserService {
    User findByUsername(String username);

    User save(UserDto userDto);

}

package com.YP.bookstore.service;

import com.YP.bookstore.model.User;
import com.YP.bookstore.model.UserDto;
import com.YP.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(UserDto userDto){
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()),userDto.getFullname(), userDto.getEmail(), userDto.getAddress(), userDto.getCardDetails());
        return userRepository.save(user);
    }



}
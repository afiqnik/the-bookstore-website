package com.YP.bookstore.repository;

import com.YP.bookstore.model.User;
import com.YP.bookstore.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

//    User save(UserDto userDto);
}
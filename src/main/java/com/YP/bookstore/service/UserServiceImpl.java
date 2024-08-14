package com.YP.bookstore.service;

import com.YP.bookstore.model.User;
import com.YP.bookstore.model.UserDto;
import com.YP.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl is a service class that implements the UserService interface.
 * It provides methods for user-related operations such as finding and saving
 * users.
 */
@Service
public class UserServiceImpl implements UserService {

    // Injecting the PasswordEncoder bean to encode passwords
    @Autowired
    PasswordEncoder passwordEncoder;

    // Injecting the UserRepository bean to interact with the user data in the
    // database
    @Autowired
    private UserRepository userRepository;

    // Constructor-based dependency injection for UserRepository
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    /**
     * Finds a user by their username.
     *
     * @param username the username to search for
     * @return the User object if found, otherwise null
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Saves a new user to the database.
     *
     * @param userDto the user data transfer object containing user details
     * @return the saved User object
     */
    @Override
    public User save(UserDto userDto) {
        // Creating a new User object from UserDto and encoding the password
        User user = new User(
                userDto.getUsername(),
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getFullname(),
                userDto.getEmail(),
                userDto.getAddress(),
                userDto.getCardDetails());
        // Saving the user to the repository
        return userRepository.save(user);
    }
}

package com.YP.bookstore.service;

import com.YP.bookstore.model.User;
import com.YP.bookstore.model.UserDto;

/**
 * UserService interface provides methods for managing user-related operations.
 * This interface defines methods to find a user by username and save a new
 * user.
 */
public interface UserService {

    /**
     * Finds and returns a user by their username.
     *
     * @param username the username of the user to find
     * @return the User object if found, otherwise null
     */
    User findByUsername(String username);

    /**
     * Saves a new user to the database.
     *
     * @param userDto the data transfer object containing user information
     * @return the saved User object
     */
    User save(UserDto userDto);

}

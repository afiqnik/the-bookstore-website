package com.YP.bookstore.repository;

import com.YP.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository interface for handling CRUD operations on User entities.
 * This interface extends JpaRepository, providing various methods to interact
 * with the database.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a User entity by its username.
     *
     * @param username the username of the user to be found
     * @return the User entity with the given username, or null if no user is found
     */
    User findByUsername(String username);
}

package com.YP.bookstore.service;

import java.util.Arrays;
import java.util.Collection;

import com.YP.bookstore.model.CustomUserDetails;
import com.YP.bookstore.model.User;
import com.YP.bookstore.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service class that implements UserDetailsService to provide custom user
 * authentication logic.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Injecting UserRepository dependency to interact with User data
    private UserRepository userRepository;

    /**
     * Constructor for CustomUserDetailsService.
     * 
     * @param userRepository the repository used to find the user by username
     */
    public CustomUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    /**
     * Locates the user based on the username. If user is not found, throws
     * UsernameNotFoundException.
     * 
     * @param username the username identifying the user whose data is required
     * @return a fully populated UserDetails object (custom implementation)
     * @throws UsernameNotFoundException if the user could not be found or the user
     *                                   has no GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Fetch user from the repository
        User user = userRepository.findByUsername(username);

        // If user is not found, throw an exception
        if (user == null) {
            throw new UsernameNotFoundException("Username or Password not found");
        }

        // Return custom UserDetails implementation
        return new CustomUserDetails(user.getUsername(), user.getPassword(), authorities(), user.getFullname());
    }

    /**
     * Provides a collection of granted authorities for the user.
     * 
     * @return a collection of granted authorities
     */
    public Collection<? extends GrantedAuthority> authorities() {
        // Assigns a single authority "USER" to the user
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }
}

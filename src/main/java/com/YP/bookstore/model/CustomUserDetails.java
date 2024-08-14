package com.YP.bookstore.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Custom implementation of UserDetails for Spring Security.
 * This class encapsulates user information to be used for authentication and
 * authorization.
 */
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String fullname;

    /**
     * Constructor to initialize CustomUserDetails with user information.
     *
     * @param username    the username of the user
     * @param password    the password of the user
     * @param authorities the authorities granted to the user
     * @param fullname    the full name of the user
     */
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
            String fullname) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.fullname = fullname;
    }

    /**
     * Gets the full name of the user.
     *
     * @return the full name of the user
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Gets the authorities granted to the user.
     *
     * @return a collection of GrantedAuthority objects
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password of the user
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username of the user
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Indicates whether the user's account has expired.
     *
     * @return true if the account is not expired, false otherwise
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked.
     *
     * @return true if the account is not locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired.
     *
     * @return true if the credentials are not expired, false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled.
     *
     * @return true if the user is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}

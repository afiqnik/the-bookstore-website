package com.YP.bookstore.model;

import lombok.Getter;
import lombok.Setter;

// Lombok annotations to generate getters and setters
@Getter
@Setter
public class UserDto {

    // Private member variables to store user information
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String address;
    private String CardDetails;

    // Constructor to initialize the UserDto object
    public UserDto(String username, String password, String fullname, String email, String address,
            String CardDetails) {
        super(); // Calls the superclass constructor (Object class in this case)
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.CardDetails = CardDetails;
    }

    // Override the toString method to provide a string representation of the
    // UserDto object
    @Override
    public String toString() {
        return "UserDto [username=" + username + ", password=" + password + ", fullname=" + fullname + " , email="
                + email + ", address=" + address + " , CardDetails=" + CardDetails + "]";
    }
}

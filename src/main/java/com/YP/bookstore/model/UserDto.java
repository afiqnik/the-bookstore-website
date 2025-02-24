package com.YP.bookstore.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// Lombok annotations to generate getters and setters
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    // Private member variables to store user information
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String address;
    private String cardDetails;

    // Override the toString method to provide a string representation of the
    // UserDto object
    @Override
    public String toString() {
        return "UserDto [username=" + username + ", password=" + password + ", fullname=" + fullname + " , email="
                + email + ", address=" + address + " , CardDetails=" + cardDetails + "]";
    }
}

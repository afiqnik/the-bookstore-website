package com.YP.bookstore.model;

import jakarta.persistence.*;
import lombok.*;

// Lombok annotations to generate getters, setters, and constructors
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // Specifies that the class is an entity and is mapped to a database table
public class User {

    @Id // Specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the primary key generation strategy
    private Long id;

    private String username;
    private String password;
    private String fullname;
    private String email;
    private String Address;
    private String CardDetails;

    // Custom constructor for creating a User object with specified values
    public User(String username, String password, String fullname, String email, String Address, String CardDetails) {
        super();
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.Address = Address;
        this.CardDetails = CardDetails;
    }

    // Overrides the default toString method to provide a custom string
    // representation of the User object
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname
                + ", email=" + email + ", Address=" + Address + ", CardDetails=" + CardDetails + "]";
    }
}

package com.YP.bookstore.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_gen")
    @TableGenerator(
            name = "user_gen",
            table = "users_seq",
            pkColumnName = "sequence_name",
            valueColumnName = "next_val",
            pkColumnValue = "user_seq",
            allocationSize = 1 // Set the allocation size to 1 to prevent jumps
    )
    private Long id;

    private String username;

    private String password;

    private String fullname;

    private String email;

    private String Address;

    private String CardDetails;

    public User(String username, String password, String fullname, String email, String Address, String CardDetails) {
        super();
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.Address = Address;
        this.CardDetails = CardDetails;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname + ", email=" + email + ", Address=" + Address + ", CardDetails=]";
    }
}

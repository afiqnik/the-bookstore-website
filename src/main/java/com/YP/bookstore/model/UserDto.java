package com.YP.bookstore.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {


    private String username;
    private String password;
    private String fullname;
    private String email;
    private String address;
    private String CardDetails;

    public UserDto(String username, String password, String fullname, String email, String address, String CardDetails) {
        super();
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.CardDetails = CardDetails;
    }

    @Override
    public String toString() {
        return "UserDto [username=" + username + ", password=" + password + ", fullname=" + fullname + " , email=" + email + ", address=" + address + " , CardDetails=" + CardDetails + "]";
    }
}

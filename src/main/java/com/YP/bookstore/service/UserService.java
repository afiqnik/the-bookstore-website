package com.YP.bookstore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YP.bookstore.model.User;
import com.YP.bookstore.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        
        return userRepository.findAll();
    }

    // User findbyUsername(String username);
	// public User saveUser(User user);

	// public UserDtls getUserByEmail(String email);

	// public List<UserDtls> getUsers(String role);

	// public Boolean updateAccountStatus(Integer id, Boolean status);

	// public void increaseFailedAttempt(UserDtls user);

	// public void userAccountLock(UserDtls user);

	// public boolean unlockAccountTimeExpired(UserDtls user);

	// public void resetAttempt(int userId);

	// public void updateUserResetToken(String email, String resetToken);
	
	// public UserDtls getUserByToken(String token);
	
	// public UserDtls updateUser(UserDtls user);
	
	// public UserDtls updateUserProfile(UserDtls user,MultipartFile img);

}


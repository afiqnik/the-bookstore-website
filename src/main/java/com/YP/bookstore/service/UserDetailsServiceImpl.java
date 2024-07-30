// package com.YP.bookstore.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.YP.bookstore.config.CustomUser;
// import com.YP.bookstore.model.User;
// import com.YP.bookstore.repository.UserRepository;

// // import com.YP.bookstore.dto.UserDetails;

// @Service
// public class UserDetailsServiceImpl implements UserDetailsService {
    
//     @Autowired
//     private UserRepository userRepository;

//     public UserDetailsServiceImpl(){

//     }

//     public UserDetailsServiceImpl(UserRepository userRepository){
//         this.userRepository=userRepository;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//         User user = userRepository.findByUserName(username);

//         if(user==null){
//             throw new UsernameNotFoundException("dok jupo");
//         }
//         return new CustomUser(user);
//     }
//     // public void findByUserName();


// }

// package com.YP.bookstore.config;

// import java.util.Arrays;
// import java.util.Collection;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import com.YP.bookstore.model.User;
// // import com.ecom.model.UserDtls;

// public class CustomUser implements UserDetails {

// 	private User user;

// 	public CustomUser(User user) {
// 		super();
// 		this.user = user;
// 	}

// 	@Override
// 	public Collection<? extends GrantedAuthority> getAuthorities() {
// 		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getUsername());
// 		return Arrays.asList(authority);
// 	}

// 	@Override
// 	public String getPassword() {
// 		return user.getPassword();
// 	}

// 	@Override
// 	public String getUsername() {
// 		return user.getUsername();
// 	}

// 	// @Override
// 	// public boolean isAccountNonExpired() {
// 	// 	return true;
// 	// }

// 	// @Override
// 	// public boolean isAccountNonLocked() {
// 	// 	return user.getAccountNonLocked();
// 	// }

// 	// @Override
// 	// public boolean isCredentialsNonExpired() {
// 	// 	return true;
// 	// }

// 	// @Override
// 	// public boolean isEnabled() {
// 	// 	return user.getIsEnable();
// 	// }

// }


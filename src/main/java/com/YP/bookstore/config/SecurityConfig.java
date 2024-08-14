package com.YP.bookstore.config;

import com.YP.bookstore.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * SecurityConfig class configures the security settings for the application.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Injecting CustomUserDetailsService to handle user authentication.
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    /**
     * Bean for password encoding using BCrypt.
     *
     * @return PasswordEncoder instance.
     */
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the security filter chain.
     *
     * @param http HttpSecurity instance.
     * @return SecurityFilterChain instance.
     * @throws Exception if an error occurs.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Disable CSRF protection.
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/order").authenticated() // Only authenticated users can access "/order".
                .requestMatchers("/addToCart/{id}").authenticated() // Only authenticated users can access "/addToCart/{id}".
                .requestMatchers("/cart").authenticated() // Only authenticated users can access "/cart".
                .requestMatchers("/**").permitAll() // Permit all other requests.
            )
            .formLogin(formlogin -> formlogin
                .loginPage("/login") // Custom login page.
                .loginProcessingUrl("/login") // URL to submit login credentials.
                .defaultSuccessUrl("/", true) // Redirect to home page on successful login.
                .permitAll() // Allow access to the login page for all users.
            )
            .logout(logout -> logout
                .invalidateHttpSession(true) // Invalidate session on logout.
                .clearAuthentication(true) // Clear authentication on logout.
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // URL to trigger logout.
                .logoutSuccessUrl("/login?logout").permitAll() // Redirect to login page with logout message.
            );

        return http.build();
    }

    /**
     * Configures the authentication manager with custom user details service and password encoder.
     *
     * @param auth AuthenticationManagerBuilder instance.
     * @throws Exception if an error occurs.
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
}

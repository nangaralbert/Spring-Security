package com.albert.Spring.Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetailsOne = User.withUsername("User1")
                .password(passwordEncoder().encode("pass1")).build();
        UserDetails userDetailsTwo = User.withUsername("User2")
                .password(passwordEncoder().encode("pass2")).build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin1")).build();
        return new InMemoryUserDetailsManager(admin,userDetailsOne,userDetailsTwo);
    }

 
}

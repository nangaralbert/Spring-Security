package com.albert.Spring.Security.service;

import com.albert.Spring.Security.model.UserPrincipal;
import com.albert.Spring.Security.model.Users;
import com.albert.Spring.Security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);

        if (user==null){
            System.out.println("User not Found");
            throw new UsernameNotFoundException("User not Found");
        }

        return new UserPrincipal(user);
    }
}

package com.example.springsecurityexample.Service;

import com.example.springsecurityexample.Model.UserPrincipal;
import com.example.springsecurityexample.Model.Users;
import com.example.springsecurityexample.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=userRepo.findByUsername(username);
        if(user==null)
        {
            System.out.println("user not found");
            throw  new UsernameNotFoundException("user not found");
        }
        else {
                return new UserPrincipal(user);
        }
    }
}

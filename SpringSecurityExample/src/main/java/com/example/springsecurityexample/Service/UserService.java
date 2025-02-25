package com.example.springsecurityexample.Service;

import com.example.springsecurityexample.Model.Users;
import com.example.springsecurityexample.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;




    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public Users register(Users user) {
  //   user.setUsername(encoder.encode(user.getUsername()));
     user.setPassword(encoder.encode(user.getPassword()));
     return userRepo.save(user);
    }

}

package com.example.kreideacademy.Services;

import com.example.kreideacademy.Models.Users;
import com.example.kreideacademy.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public Users getUser(String userName){
        return userRepo.findById(userName).get();
    }

}

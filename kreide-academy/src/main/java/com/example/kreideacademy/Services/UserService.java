package com.example.kreideacademy.Services;

import com.example.kreideacademy.Models.Users;
import com.example.kreideacademy.Repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public Users getUser(String userName){
        return userRepo.findById(userName).get();
    }
    public void adduser(Users user) {
        userRepo.save(user);
    }

    public List<Users> getUserAll()
    {
        List<Users> projects = userRepo.findAll();
        return projects;
    }
}

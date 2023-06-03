package com.example.kreideacademy.Controllers;

import com.example.kreideacademy.Models.Users;
import com.example.kreideacademy.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/11")
    public String Checklogin(String Username, String password){
        return "dashboard";
    }

    @PostMapping("/login")
    public ModelAndView Ceklogin(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord){


        Users obj = userService.getUser(userName);

        if(obj != null)
        {
            if(obj.getPassword().equals(passWord))
            {
                ModelAndView mv=new ModelAndView("dashboard");

                return mv;
            }
            else {
                ModelAndView mv=new ModelAndView("login");
                return mv;

            }
        }
        else {
            ModelAndView mv=new ModelAndView("login");
            return mv;
        }



    }

    @GetMapping("/")
    public String masukLogin(){
        return "login.html";
    }
}

package com.example.kreideacademy.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    public String Checklogin(String Username, String password){
        return "dashboard";
    }
    @GetMapping("/test")
    public String Ceklogin(){
        return "dashboard";
    }
}

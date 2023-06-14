package com.example.kreideacademy.Controllers;

import com.example.kreideacademy.Models.Students;
import com.example.kreideacademy.Models.Users;
import com.example.kreideacademy.Repositories.PaketRepository;
import com.example.kreideacademy.Services.PaketService;
import com.example.kreideacademy.Services.StudentService;
import com.example.kreideacademy.Services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private PaketService paketService;

    @GetMapping("/dashboard")
    public ModelAndView Checklogin(HttpSession session, HttpServletResponse response) throws IOException {
        String loginData = (String) session.getAttribute("username");
        if (loginData != null) {
            ModelAndView mv = new ModelAndView("dashboard");
            List<Users> listUser = userService.getUserAll();
            List<Students> listStudent = studentService.getAllStudent();

            mv.addObject("teachers", listUser);
            mv.addObject("students", listStudent);
            return mv;
        }
        else {
            response.sendRedirect("/");

            return new ModelAndView("login");
        }

    }


    @GetMapping("/logout")
    public void logOut(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
        response.sendRedirect("/");
    }


    @PostMapping("/createUser")
    public void createUser(@RequestParam("usernameBaru") String userName, @RequestParam("passwordBaru") String passWord, HttpServletResponse response) throws IOException{
        String user = userName;
        String pass = passWord;
        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        Map<String, String> body= new HashMap<String, String>(){{
            put("username", userName);
            put("password", passWord);
            put("level", "admin");
        }};

        final Users userObj = mapper.convertValue(body, Users.class);

        userService.adduser(userObj);

        response.sendRedirect("/dashboard");
    }


    @PostMapping("/createPaket")
    public void createPaket(@RequestParam("namaPaket") String paket, HttpServletResponse response) throws IOException{

        paketService.addPaket(paket);

        response.sendRedirect("/dashboard");
    }


    @PostMapping("/addStudent")
    public void addStudent(@RequestParam("chosenTeacher") String teacher, @RequestParam("studentName") String studentName, HttpServletResponse response) throws IOException{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        Map<String, String> body= new HashMap<String, String>(){{
            put("studentName", studentName);
            put("fk_userid", teacher);
        }};
        studentService.addStudent(studentName, teacher);
        response.sendRedirect("/dashboard");
    }

    @PostMapping("/login")
    public void Ceklogin(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, HttpSession session, HttpServletResponse response) throws IOException {
        String loginData = (String) session.getAttribute("username");
        if (loginData != null) {
            response.sendRedirect("/dashboard");
        } else {
            try {
                Users obj = userService.getUser(userName);
                if (obj != null) {
                    if (obj.getPassword().equals(passWord)) {
                        session.setAttribute("username", userName);
                        session.setAttribute("level", ((String) obj.getLevel()));
                        response.sendRedirect("/dashboard");

                    } else {
                        session.setAttribute("msg", "password anda salah");
                        response.sendRedirect("/");

                    }
                } else {
                    session.setAttribute("msg", "user tidak ditemukan");
                    response.sendRedirect("/");

                }
            } catch (Exception e) {
                session.setAttribute("msg", "user tidak ditemukan");
                response.sendRedirect("/");
            }

        }


    }

    @GetMapping("/")
    public ModelAndView masukLogin(HttpSession session, HttpServletResponse response) throws IOException {


        return new ModelAndView("login");


    }
}

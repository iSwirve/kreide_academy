package com.example.kreideacademy.Services;

import com.example.kreideacademy.Models.Students;
import com.example.kreideacademy.Repositories.StudentRepository;
import com.example.kreideacademy.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepo;

    public void addStudent(String Student, String teacher, int paketid)
    {
        studentRepo.insertStudent(Student, teacher, paketid);
    }
    public List<Students> getAllStudent()
    {
        return studentRepo.findAll();
    }
}

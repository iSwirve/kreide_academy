package com.example.kreideacademy.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="students") //otomatis membuat tabel dengan hibernate (application.properties)
@Getter
@Setter
public class Students {

    @Id
    String studentID;
    String studentName;
    String mendaftarSejak;




}

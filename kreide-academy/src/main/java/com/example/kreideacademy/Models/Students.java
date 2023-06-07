package com.example.kreideacademy.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

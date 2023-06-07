package com.example.kreideacademy.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="attendance") //otomatis membuat tabel dengan hibernate (application.properties)
@Getter
@Setter
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int att_id;
    private int week;
    private String month;
    private int year;
    private String status;
}

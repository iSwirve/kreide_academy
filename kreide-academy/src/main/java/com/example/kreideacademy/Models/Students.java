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
    int studentID;
    String studentName;
    String mendaftarSejak;

    @ManyToOne
    @JoinColumn(name="fk_userid", nullable=false)
    private Users teacher;

    @ManyToOne
    @JoinColumn(name="fk_paketid", nullable=false)
    private Paket paket;







}

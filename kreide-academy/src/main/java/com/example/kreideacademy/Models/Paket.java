package com.example.kreideacademy.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Paket") //otomatis membuat tabel dengan hibernate (application.properties)
@Getter
@Setter
public class Paket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paketid;
    private String namaPaket;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_paketid", referencedColumnName = "paketid")
    private List<Students> students;
}

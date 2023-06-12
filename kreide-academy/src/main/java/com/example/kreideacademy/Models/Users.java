package com.example.kreideacademy.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="users") //otomatis membuat tabel dengan hibernate (application.properties)
@Getter
@Setter
public class Users {
    @Id
    private String username;
    private String password;
    private String level;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_userid", referencedColumnName = "username")
    private List<Students> students;
}

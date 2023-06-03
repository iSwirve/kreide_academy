package com.example.kreideacademy.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users") //otomatis membuat tabel dengan hibernate (application.properties)
@Getter
@Setter
public class Users {
    @Id
    private String username;
    private String password;
}

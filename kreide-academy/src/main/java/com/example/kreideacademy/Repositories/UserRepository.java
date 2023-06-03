package com.example.kreideacademy.Repositories;

import com.example.kreideacademy.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {

}

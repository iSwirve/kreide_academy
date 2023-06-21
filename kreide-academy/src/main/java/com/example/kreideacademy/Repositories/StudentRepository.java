package com.example.kreideacademy.Repositories;

import com.example.kreideacademy.Models.Students;
import com.example.kreideacademy.Models.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Students, String> {
    @Modifying
    @Query(value = "insert into Students (student_name,fk_userid, fk_paketid) VALUES (:insertLink,:id, :id2)", nativeQuery = true)
    @Transactional
    public void insertStudent(@Param("insertLink") String insertLink, @Param("id") String id, @Param("id2") int id2);


}

package com.example.kreideacademy.Repositories;

import com.example.kreideacademy.Models.Paket;
import com.example.kreideacademy.Models.Students;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaketRepository extends JpaRepository<Paket, Integer> {
    @Modifying
    @Query(value = "insert into Paket (student_name) VALUES (:id)", nativeQuery = true)
    @Transactional
    public void insertPaket(@Param("insertLink") String insertLink);

}

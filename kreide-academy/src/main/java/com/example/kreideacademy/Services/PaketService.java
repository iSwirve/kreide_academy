package com.example.kreideacademy.Services;

import com.example.kreideacademy.Models.Paket;
import com.example.kreideacademy.Repositories.PaketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaketService {
    @Autowired
    PaketRepository paketRepo;

    public void addPaket(String namaPaket)
    {
        paketRepo.insertPaket(namaPaket);
    }
    public List<Paket> getAllPaket(){
        return paketRepo.findAll();
    }
}

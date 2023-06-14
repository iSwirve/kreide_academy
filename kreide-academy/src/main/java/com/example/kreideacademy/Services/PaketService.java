package com.example.kreideacademy.Services;

import com.example.kreideacademy.Repositories.PaketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaketService {
    @Autowired
    PaketRepository paketRepo;

    public void addPaket(String namaPaket)
    {
        paketRepo.insertPaket(namaPaket);
    }
}

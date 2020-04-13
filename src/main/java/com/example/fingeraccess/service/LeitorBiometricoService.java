package com.example.fingeraccess.service;

import java.util.List;

import com.example.fingeraccess.entidade.LeitorBiometrico;
import com.example.fingeraccess.repository.LeitorBiometricoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeitorBiometricoService {

    @Autowired
    private LeitorBiometricoRepository repository;
    
    public List<LeitorBiometrico> getLeitoresBiometricos() {
        return repository.findAll();
    }
}
package com.example.fingeraccess.service;

import java.util.List;

import com.example.fingeraccess.entidade.Usuario;
import com.example.fingeraccess.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UsuarioService
 */

 @Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    
    public List<Usuario> getUsuarios() {
        return repository.findAll();
    }
}
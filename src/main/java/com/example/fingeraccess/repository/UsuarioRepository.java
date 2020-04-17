package com.example.fingeraccess.repository;

import com.example.fingeraccess.entidade.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
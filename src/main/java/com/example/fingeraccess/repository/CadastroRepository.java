package com.example.fingeraccess.repository;

import com.example.fingeraccess.entidade.Cadastro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

}
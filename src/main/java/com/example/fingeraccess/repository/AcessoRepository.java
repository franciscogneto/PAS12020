package com.example.fingeraccess.repository;

import com.example.fingeraccess.entidade.Acesso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessoRepository extends JpaRepository<Acesso, Long> {

}
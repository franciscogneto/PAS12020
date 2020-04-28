package com.example.fingeraccess.repository;

import com.example.fingeraccess.entidade.Master;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepository extends JpaRepository<Master,Integer> {

    public Master findByUsuario(String pUsuario);
}
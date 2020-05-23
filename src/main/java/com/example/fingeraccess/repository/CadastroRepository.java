package com.example.fingeraccess.repository;

import com.example.fingeraccess.entidade.Cadastro;
import com.example.fingeraccess.entidade.IdCadastro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, IdCadastro> {
    public Cadastro findByIdCadastroAndIdLeitorBiometrico(Long idCadastro, Long idLeitorBiometrico);
}
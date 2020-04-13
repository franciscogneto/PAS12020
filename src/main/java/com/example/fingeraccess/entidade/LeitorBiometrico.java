package com.example.fingeraccess.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LeitorBiometrico INSERT INTO LEITOR_BIOMETRICO VALUES( 1000, 125, 'Voktta',  'Principal', 'adm123')
 */

@Entity
@Table(name="LeitorBiometrico")
public class LeitorBiometrico implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", nullable=false, unique=true)
    private int id;

    @Column(name="local", nullable=false, unique=false)
    private String local;

    @Column(name="capacidade", nullable=false, unique=false)
    private int capacidade;

    @Column(name="fabricante", nullable=false, unique=false)
    private String fabricante;

    @Column(name="senha", nullable=false, unique=false)
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "LeitorBiometrico [capacidade=" + capacidade + ", fabricante=" + fabricante + ", id=" + id + ", local="
                + local + "]";
    }
}
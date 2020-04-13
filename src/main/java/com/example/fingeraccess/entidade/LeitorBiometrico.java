package com.example.fingeraccess.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * LeitorBiometrico INSERT INTO LEITOR_BIOMETRICO VALUES( 1000, 125, 'Voktta',  'Principal', 'adm123')
 */

@Entity
public class LeitorBiometrico implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    private int id;
    private String local;
    private int capacidade;
    private String fabricante;
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

    public void setSenha(String senha) {
        this.senha = senha;
    }   

    @Override
    public String toString() {
        return "LeitorBiometrico [capacidade=" + capacidade + ", fabricante=" + fabricante + ", id=" + id + ", local="
                + local + "]";
    }
}
package com.example.fingeraccess.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cadastro implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Id
    private long idLeitor;
    private long idUsuario;
    private String dataCadastro;

    public Cadastro() {
    }

    public Cadastro(long idLeitor, long idUsuario, String dataCadastro) {
        this.idLeitor = idLeitor;
        this.idUsuario = idUsuario;
        this.dataCadastro = dataCadastro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdLeitor() {
        return idLeitor;
    }

    public void setIdLeitor(long idLeitor) {
        this.idLeitor = idLeitor;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Cadastro [dataCadastro=" + dataCadastro + ", id=" + id + ", idLeitor=" + idLeitor + ", idUsuario="
                + idUsuario + "]";
    }
}
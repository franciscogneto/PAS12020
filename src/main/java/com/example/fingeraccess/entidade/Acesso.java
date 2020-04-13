package com.example.fingeraccess.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acesso implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numAcesso;
    private long idCadastro;
    private long idLeitor;
    private long idUsuario;
    private String dataAcesso;

    public Acesso() {
    }

    public Acesso(long idCadastro, long idLeitor, long idUsuario, String dataAcesso) {
        this.idCadastro = idCadastro;
        this.idLeitor = idLeitor;
        this.idUsuario = idUsuario;
        this.dataAcesso = dataAcesso;
    }

    public long getNumAcesso() {
        return numAcesso;
    }

    public void setNumAcesso(long numAcesso) {
        this.numAcesso = numAcesso;
    }

    public long getIdCadastro() {
        return idCadastro;
    }

    public void setIdCadastro(long idCadastro) {
        this.idCadastro = idCadastro;
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

    public String getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(String dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

    @Override
    public String toString() {
        return "Acesso [dataAcesso=" + dataAcesso + ", idCadastro=" + idCadastro + ", idLeitor=" + idLeitor
                + ", idUsuario=" + idUsuario + ", numAcesso=" + numAcesso + "]";
    }

}
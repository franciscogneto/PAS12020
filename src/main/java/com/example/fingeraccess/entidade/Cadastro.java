package com.example.fingeraccess.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@IdClass(IdCadastro.class)
public class Cadastro implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="IDCadastro", nullable=false, unique=false)
    private long idCadastro;

    @Id
    private long idLeitorBiometrico;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idLeitorCadastro")
    private LeitorBiometrico leitorBiometrico;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idUsuarioCadastro")
    private Usuario usuario;
  
    @Column(name="dataCadastro", nullable=false, unique=false)
    private String dataCadastro;

    public Cadastro() {
    }

    public long getIdCadastro() {
        return idCadastro;
    }

    public void setIdCadastro(long idCadastro) {
        this.idCadastro = idCadastro;
    }

    public long getIdLeitorBiometrico() {
        return idLeitorBiometrico;
    }

    public void setIdLeitorBiometrico(long idLeitorBiometrico) {
        this.idLeitorBiometrico = idLeitorBiometrico;
    }

    public LeitorBiometrico getLeitorBiometrico() {
        return leitorBiometrico;
    }

    public void setLeitorBiometrico(LeitorBiometrico leitorBiometrico) {
        this.leitorBiometrico = leitorBiometrico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Cadastro [dataCadastro=" + dataCadastro + ", idCadastro=" + idCadastro + ", idLeitorBiometrico="
                + idLeitorBiometrico + ", leitorBiometrico=" + leitorBiometrico + ", usuario=" + usuario + "]";
    }
}
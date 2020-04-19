package com.example.fingeraccess.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@IdClass(IdCadastro.class)
public class Cadastro implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="IDCadastro", nullable=false, unique=true)
    private long idCadastro;

    @Id
    @OneToOne
    @JoinColumn(name="idLeitorCadastro", referencedColumnName="IDLeitor")
    private LeitorBiometrico leitorBiometrico;

    @OneToOne
    @JoinColumn(name="idUsuario", referencedColumnName="IDUsuario")
    private Usuario usuario;
  
    @Column(name="dataCadastro", nullable=false, unique=false)
    private String dataCadastro;

    public Cadastro() {
    }

    public Cadastro(LeitorBiometrico leitorBiometrico, Usuario usuario, String dataCadastro) {
        this.leitorBiometrico = leitorBiometrico;
        this.usuario = usuario;
        this.dataCadastro = dataCadastro;
    }

    public long getIdCadastro() {
        return idCadastro;
    }

    public void setIdCadastro(long idCadastro) {
        this.idCadastro = idCadastro;
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
        return "Cadastro [dataCadastro=" + dataCadastro + ", idCadastro=" + idCadastro + ", leitorBiometrico="
                + leitorBiometrico + ", usuario=" + usuario + "]";
    }
}
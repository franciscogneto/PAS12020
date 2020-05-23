package com.example.fingeraccess.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Acesso")
public class Acesso implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDAcesso", nullable=false, unique=true)
    private long numAcesso;

    //@ManyToOne
    //@JoinColumn(name="idCadastroAcesso", referencedColumnName="IDCadastro")
    //@JoinColumn(name="idLeitorCadastroAcesso", referencedColumnName="idLeitorCadastro")
    //private Cadastro cadastro;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idLeitorAcesso")
    private LeitorBiometrico leitorBiometrico;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idUsuarioAcesso")
    private Usuario usuario;
    
    @Column(name="dataAcesso", nullable=false, unique=false)
    private String dataAcesso;

    public Acesso() {
    }

    public Acesso(long numAcesso, LeitorBiometrico leitorBiometrico, Usuario usuario, String dataAcesso) {
        this.numAcesso = numAcesso;
        this.leitorBiometrico = leitorBiometrico;
        this.usuario = usuario;
        this.dataAcesso = dataAcesso;
    }

    public long getNumAcesso() {
        return numAcesso;
    }

    public void setNumAcesso(long numAcesso) {
        this.numAcesso = numAcesso;
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

    public String getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(String dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

    @Override
    public String toString() {
        return "Acesso [dataAcesso=" + dataAcesso + ", leitorBiometrico=" + leitorBiometrico + ", numAcesso="
                + numAcesso + ", usuario=" + usuario + "]";
    }
}
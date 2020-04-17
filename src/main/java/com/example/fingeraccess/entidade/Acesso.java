package com.example.fingeraccess.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Acesso")
public class Acesso implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="NUM", nullable=false, unique=true)
    private long numAcesso;

    @OneToOne
    @JoinColumn(name="idCadastro", referencedColumnName="ID")
    private Cadastro cadastro;

    @OneToOne
    @JoinColumn(name="idLeitor", referencedColumnName="ID")
    private LeitorBiometrico leitorBiometrico;

    @OneToOne
    @JoinColumn(name="idUsuario", referencedColumnName="ID")
    private Usuario usuario;
    
    @Column(name="dataAcesso", nullable=false, unique=false)
    private String dataAcesso;

    public Acesso() {
    }

    public Acesso(Cadastro cadastro, LeitorBiometrico leitorBiometrico, Usuario usuario, String dataAcesso) {
        this.cadastro = cadastro;
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

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
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
        return "Acesso [cadastro=" + cadastro + ", dataAcesso=" + dataAcesso + ", leitorBiometrico=" + leitorBiometrico
                + ", numAcesso=" + numAcesso + ", usuario=" + usuario + "]";
    }
}
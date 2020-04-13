package com.example.fingeraccess.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cadastro")
public class Cadastro implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", nullable=false, unique=true)
    private long id;

    @Id
    @ManyToMany
    @JoinColumn(name="idLeitor", referencedColumnName="ID")
    private LeitorBiometrico  leitorBiometrico;

    @ManyToMany
    @JoinColumn(name="idUsuario", referencedColumnName="ID")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "Cadastro [dataCadastro=" + dataCadastro + ", id=" + id + ", leitorBiometrico=" + leitorBiometrico
                + ", usuario=" + usuario + "]";
    }
}
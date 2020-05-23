package com.example.fingeraccess.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @Column(name="IDLeitor", nullable=false, unique=true)
    private long idLeitor;

    @Column(name="local", nullable=false, unique=false)
    private String local;

    @Column(name="capacidade", nullable=false, unique=false)
    private int capacidade;

    @Column(name="fabricante", nullable=false, unique=false)
    private String fabricante;

    @Column(name="senha", nullable=false, unique=false)
    private String senha;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="idLeitorCadastro")
    private List<Cadastro> cadastros;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="idLeitorAcesso")
    private List<Acesso> acessos;

    public long getIdLeitor() {
        return idLeitor;
    }

    public void setIdLeitor(long idLeitor) {
        this.idLeitor = idLeitor;
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

    public List<Cadastro> getCadastros() {
        return cadastros;
    }

    public void setCadastros(List<Cadastro> cadastros) {
        this.cadastros = cadastros;
    }

    public List<Acesso> getAcessos() {
        return acessos;
    }

    public void setAcessos(List<Acesso> acessos) {
        this.acessos = acessos;
    }

    @Override
    public String toString() {
        return "LeitorBiometrico [capacidade=" + capacidade + ", fabricante=" + fabricante + ", idLeitor=" + idLeitor
                + ", local=" + local + ", senha=" + senha + "]";
    }
}
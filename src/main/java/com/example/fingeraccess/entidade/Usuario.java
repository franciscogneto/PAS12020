package com.example.fingeraccess.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Usuario INSERT INTO USUARIO VALUES(0,  '15991247823', 'Sorocaba', '48999603873',  '2000-06-08', 'vinicius.souzacss@gmail.com', 'Rua Pedro Alvares Cabral, n.522',  'VINÍCIUS', '33885098')
 */

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", nullable=false, unique=true)
    private int id;

    @Column(name="nome", nullable=false, unique=false)
    private String nome;

    @Column(name="cpf", nullable=false, unique=false)
    private String cpf;

    @Column(name="datanasc", nullable=false, unique=false)
    private String datanasc;

    @Column(name="cidade", nullable=false, unique=false)
    private String cidade;

    @Column(name="endereco", nullable=false, unique=false)
    private String endereco;

    @Column(name="email", nullable=false, unique=false)
    private String email;

    @Column(name="telefone", nullable=false, unique=false)
    private String telefone;

    @Column(name="celular", nullable=false, unique=false)
    private String celular;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Usuario [celular=" + celular + ", cidade=" + cidade + ", cpf=" + cpf + ", datanasc=" + datanasc
                + ", email=" + email + ", endereco=" + endereco + ", id=" + id + ", nome=" + nome + ", telefone="
                + telefone + "]";
    }

}
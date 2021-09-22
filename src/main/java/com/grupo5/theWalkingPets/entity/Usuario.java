package com.grupo5.theWalkingPets.entity;

import javax.persistence.*;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Colunas.ID)
    private Long id;

    @Column(name = Colunas.NOME)
    private String nome;

    @Column(name = Colunas.EMAIL)
    private String email;

    @Column(name = Colunas.SENHA)
    private String senha;

    @Column(name = Colunas.BAIRRO)
    private String bairro;//Converter para objeto ?

    @Column(name = Colunas.TELEFONE)
    private String telefone;//Converter para objeto ?

    @Column(name = Colunas.VERIFICADO)
    private Boolean verificado;

    public Usuario(Long id, String nome, String email, String senha, String bairro, String telefone, Boolean verificado) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.bairro = bairro;
        this.telefone = telefone;
        this.verificado = verificado;
    }

    public Usuario() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    public static class Colunas{
            public static final String ID = " ID";
            public static final String NOME = "NOME";
            public static final String EMAIL = "EMAIL";
            public static final String SENHA = "SENHA";
            public static final String BAIRRO = "BAIRRO";
            public static final String TELEFONE = "TELEFONE";
            public static final String VERIFICADO = "VERIFICADO";
    }
}

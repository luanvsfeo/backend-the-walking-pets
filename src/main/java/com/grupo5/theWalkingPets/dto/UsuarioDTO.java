package com.grupo5.theWalkingPets.dto;

public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private String cep;
    private String telefone;

    public UsuarioDTO(String nome, String email, String senha, String cep, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cep = cep;
        this.telefone = telefone;
    }

    public UsuarioDTO() {
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}

package com.grupo5.theWalkingPets.dto;

import com.grupo5.theWalkingPets.entity.Usuario;

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

    public boolean isValid() {
        return this.nome != null &&
                this.email != null &&
                this.senha != null &&
                this.cep != null &&
                this.telefone != null;
    }

    public Usuario converterParaUsuarioComLocalizacao(ViaCepDTO viaCepDTO) {
        Usuario usuario =  converterParaUsuario();
        usuario.popularLocalizacao(viaCepDTO);
        return usuario;
    }

    public Usuario converterParaUsuario() {
        return new Usuario(this.nome, this.email, this.senha, this.telefone);
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

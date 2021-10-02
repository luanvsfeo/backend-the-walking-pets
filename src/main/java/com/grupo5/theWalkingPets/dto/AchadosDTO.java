package com.grupo5.theWalkingPets.dto;

public class AchadosDTO {

    private Long id;

    private String foto;

    private String bairro;

    private String comentario;

    private String nome;

    public AchadosDTO(Long id, String foto, String bairro, String comentario, String nome) {
        this.id = id;
        this.foto = foto;
        this.bairro = bairro;
        this.comentario = comentario;
        this.nome = nome;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

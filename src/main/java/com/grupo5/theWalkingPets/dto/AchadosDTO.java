package com.grupo5.theWalkingPets.dto;

import com.grupo5.theWalkingPets.entity.Achados;

import java.util.Date;

public class AchadosDTO {

    private Long id;

    private String foto;

    private String bairro;

    private String comentario;

    private String nome;

    public AchadosDTO() {
    }

    public AchadosDTO(Long id, String foto, String bairro, String comentario, String nome) {
        this.id = id;
        this.foto = foto;
        this.bairro = bairro;
        this.comentario = comentario;
        this.nome = nome;
    }

    public boolean isValid(){
        if(this.foto != null && this.bairro != null){
            return true;
        }
        return false;
    }

    public Achados converterParaAchados(){
        Achados achados = new Achados();
        achados.setComentario(this.comentario);
        achados.setBairro(this.bairro);
        achados.setDateOcorrencia(new Date());
        achados.setFoto(this.foto);
        achados.setNome(this.nome);
        achados.setId(this.id);
        return achados;
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

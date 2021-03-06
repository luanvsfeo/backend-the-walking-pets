package com.grupo5.theWalkingPets.dto;

import com.grupo5.theWalkingPets.entity.Achados;

import java.util.Date;

public class AchadosDTO {

    private Long id;

    private String fotoBase64;

    private String bairro;

    private String comentario;

    private String nome;

    public AchadosDTO() {
    }

    public AchadosDTO(Long id, String foto, String bairro, String comentario, String nome) {
        this.id = id;
        this.fotoBase64 = foto;
        this.bairro = bairro;
        this.comentario = comentario;
        this.nome = nome;
    }

    public boolean isValid(){
        if(this.fotoBase64 != null && this.bairro != null){
            return true;
        }
        return false;
    }

    public Achados converterParaAchados(){
        Achados achados = new Achados();
        achados.setComentario(this.comentario);
        achados.setBairro(this.bairro);
        achados.setDateOcorrencia(new Date());
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

    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
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

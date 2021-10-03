package com.grupo5.theWalkingPets.entity;

import com.grupo5.theWalkingPets.dto.AchadosDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Achados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Animal.Colunas.ID)
    private Long id;

    private String foto;

    private String bairro;

    private String comentario;

    private String nome;

    private Date dateOcorrencia;

    public Achados() {
    }

    public Achados(Long id, String foto, String bairro, String comentario, String nome, Date dateOcorrencia) {
        this.id = id;
        this.foto = foto;
        this.bairro = bairro;
        this.comentario = comentario;
        this.nome = nome;
        this.dateOcorrencia = dateOcorrencia;
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

    public Date getDateOcorrencia() {
        return dateOcorrencia;
    }

    public void setDateOcorrencia(Date dateOcorrencia) {
        this.dateOcorrencia = dateOcorrencia;
    }

    public AchadosDTO converterParaDTO() {
        AchadosDTO achadosDTO = new AchadosDTO();
        achadosDTO.setComentario(this.comentario);
        achadosDTO.setNome(this.nome);
        achadosDTO.setBairro(this.bairro);
        achadosDTO.setId(this.id);

        return achadosDTO;
    }

}

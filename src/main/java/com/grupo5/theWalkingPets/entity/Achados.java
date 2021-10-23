package com.grupo5.theWalkingPets.entity;

import com.grupo5.theWalkingPets.dto.AchadosDTO;
import org.springframework.util.Base64Utils;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.Date;

@Entity
public class Achados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Animal.Colunas.ID)
    private Long id;

    private String bairro;

    private String cidade;

    private String uf;

    private String comentario;

    private String nome;

    private Date dateOcorrencia;

    private boolean mostrarTelefone;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "foto_id")
    private Foto foto;

    public Achados() {
    }

    public Achados(Long id, String bairro, String comentario, String nome, Date dateOcorrencia) {
        this.id = id;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public AchadosDTO converterParaDTO() throws SQLException {
        AchadosDTO achadosDTO = new AchadosDTO();
        achadosDTO.setComentario(this.comentario);
        achadosDTO.setNome(this.nome);
        achadosDTO.setBairro(this.bairro);
        achadosDTO.setId(this.id);

        if(this.mostrarTelefone){
            achadosDTO.setTelefone(this.usuario.getTelefone());
        }

        if(this.foto != null){
            int blobLength = (int) this.foto.getData().length();
            achadosDTO.setFotoBase64(new String(Base64Utils.encode(this.foto.getData().getBytes(1, blobLength))));
        }

        return achadosDTO;
    }


    public boolean isMostrarTelefone() {
        return mostrarTelefone;
    }

    public void setMostrarTelefone(boolean mostrarTelefone) {
        this.mostrarTelefone = mostrarTelefone;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

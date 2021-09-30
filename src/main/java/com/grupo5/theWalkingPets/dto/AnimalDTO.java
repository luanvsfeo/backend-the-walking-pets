package com.grupo5.theWalkingPets.dto;

import com.grupo5.theWalkingPets.entity.Animal;
import com.grupo5.theWalkingPets.enumx.Especie;
import com.grupo5.theWalkingPets.enumx.Porte;
import com.grupo5.theWalkingPets.enumx.Sexo;
import com.grupo5.theWalkingPets.enumx.Temperamento;
import org.springframework.web.multipart.MultipartFile;

public class AnimalDTO {

    private Long id;
    private String nome;
    private Especie especie;
    private String raca;
    private Sexo sexo;
    private String idade;
    private String pelagem;
    private Porte porte;
    private Temperamento temperamento;
    private boolean castrado;
    private boolean vacinado;
    private boolean perdido;
    private String anilha;
    private MultipartFile foto; // objeto dedicado depois


    public AnimalDTO() {
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

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public Temperamento getTemperamento() {
        return temperamento;
    }

    public void setTemperamento(Temperamento temperamento) {
        this.temperamento = temperamento;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public boolean isVacinado() {
        return vacinado;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }

    public boolean isPerdido() {
        return perdido;
    }

    public void setPerdido(boolean perdido) {
        this.perdido = perdido;
    }

    public String getAnilha() {
        return anilha;
    }

    public void setAnilha(String anilha) {
        this.anilha = anilha;
    }

    public MultipartFile getFoto() {
        return foto;
    }

    public void setFoto(MultipartFile foto) {
        this.foto = foto;
    }

    public Animal converterToAnimal(){
        return new Animal();
    }
}

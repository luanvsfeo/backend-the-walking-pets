package com.grupo5.theWalkingPets.dao.filter;

import com.grupo5.theWalkingPets.enumx.Especie;
import com.grupo5.theWalkingPets.enumx.Porte;
import com.grupo5.theWalkingPets.enumx.Sexo;
import com.grupo5.theWalkingPets.enumx.Temperamento;

public class AnimalFilter {

    private String nome;
    private Especie especie;
    private String raca;
    private Sexo sexo;
    private String idade;
    private String pelagem;
    private Porte porte;
    private Temperamento temperamento;
    private Boolean castrado;
    private Boolean vacinado;
    private String anilha;
    private Long usuarioId;
    private String cidade;
    private String bairro;
    private Boolean doar;
    private Boolean perdido;

    public AnimalFilter() {
    }

    public AnimalFilter(String nome, Especie especie, String raca, Sexo sexo, String idade, String pelagem, Porte porte, Temperamento temperamento, boolean castrado, boolean vacinado, String anilha) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.sexo = sexo;
        this.idade = idade;
        this.pelagem = pelagem;
        this.porte = porte;
        this.temperamento = temperamento;
        this.castrado = castrado;
        this.vacinado = vacinado;
        this.anilha = anilha;
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

    public String getAnilha() {
        return anilha;
    }

    public void setAnilha(String anilha) {
        this.anilha = anilha;
    }

    public Boolean getCastrado() {
        return castrado;
    }

    public void setCastrado(Boolean castrado) {
        this.castrado = castrado;
    }

    public Boolean getVacinado() {
        return vacinado;
    }

    public void setVacinado(Boolean vacinado) {
        this.vacinado = vacinado;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Boolean getDoar() {
        return doar;
    }

    public void setDoar(Boolean doar) {
        this.doar = doar;
    }

    public Boolean getPerdido() {
        return perdido;
    }

    public void setPerdido(Boolean perdido) {
        this.perdido = perdido;
    }
}

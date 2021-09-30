package com.grupo5.theWalkingPets.entity;

import com.grupo5.theWalkingPets.enumx.Especie;
import com.grupo5.theWalkingPets.enumx.Porte;
import com.grupo5.theWalkingPets.enumx.Sexo;
import com.grupo5.theWalkingPets.enumx.Temperamento;

import javax.persistence.*;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Colunas.ID)
    private Long id;

    @Column(name = Colunas.NOME)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = Colunas.ESPECIE)
    private Especie especie;

    @Column(name = Colunas.RACA)
    private String raca;

    @Enumerated(EnumType.STRING)
    @Column(name = Colunas.SEXO)
    private Sexo sexo;

    @Column(name = Colunas.IDADE)
    private String idade;

    @Column(name = Colunas.PELAGEM)
    private String pelagem;

    @Enumerated(EnumType.STRING)
    @Column(name = Colunas.PORTE)
    private Porte porte;

    @Enumerated(EnumType.STRING)
    @Column(name = Colunas.TEMPERAMENTO)
    private Temperamento temperamento;

    @Column(name = Colunas.CASTRADO)
    private boolean castrado;

    @Column(name = Colunas.VACINADO)
    private boolean vacinado;

    @Column(name = Colunas.PERDIDO)
    private boolean perdido;

    @Column(name = Colunas.ANILHA)
    private String anilha;

    @Column(name = Colunas.FOTO)
    private String foto; // objeto dedicado depois

    //DONO DO MENO
    private Usuario usuario;

    public Animal() {
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public static class Colunas {
        public static final String ID = "ID";
        public static final String NOME = "NOME";
        public static final String ESPECIE = "ESPECIE";
        public static final String RACA = "RACA";
        public static final String SEXO = "SEXO";
        public static final String IDADE = "IDADE";
        public static final String PELAGEM = "PELAGEM";
        public static final String PORTE = "PORTE";
        public static final String TEMPERAMENTO = "TEMPERAMENTO";
        public static final String CASTRADO = "CASTRADO";
        public static final String VACINADO = "VACINADO";
        public static final String PERDIDO = "PERDIDO";
        public static final String ANILHA = "ANILHA";
        public static final String FOTO = "FOTO";
    }
}

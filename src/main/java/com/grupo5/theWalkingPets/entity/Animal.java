package com.grupo5.theWalkingPets.entity;

import com.grupo5.theWalkingPets.dto.AnimalDTO;
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
    private String raca;// provavelmente vai vim do banco mesmo ^^

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

    @Column(name = Colunas.DOAR)
    private boolean doar;

    @Column(name = Colunas.ANILHA)
    private String anilha;

    @Column(name = Colunas.FOTO)
    private String foto; // objeto dedicado depois

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Animal() {
    }


    public Animal(Long id, String nome, Especie especie, String raca, Sexo sexo, String idade, String pelagem, Porte porte, Temperamento temperamento, boolean castrado, boolean vacinado, boolean perdido, String anilha, String foto, Usuario usuario) {
        this.id = id;
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
        this.perdido = perdido;
        this.anilha = anilha;
        this.foto = foto;
        this.usuario = usuario;
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

    public boolean isDoar() {
        return doar;
    }

    public void setDoar(boolean doar) {
        this.doar = doar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public AnimalDTO converterParaDTO(){
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setAnilha(this.anilha);
        animalDTO.setCastrado(this.castrado);
        animalDTO.setEspecie(this.especie);
        animalDTO.setIdade(this.idade);
        animalDTO.setNome(this.nome);
        animalDTO.setPelagem(this.pelagem);
        animalDTO.setPerdido(this.perdido);
        animalDTO.setPorte(this.porte );
        animalDTO.setRaca(this.raca);
        animalDTO.setTemperamento(this.temperamento);
        animalDTO.setPorte(this.porte);
        animalDTO.setVacinado(this.vacinado);
        animalDTO.setSexo(this.sexo);
        animalDTO.setId(this.id);
        animalDTO.setBairro(this.usuario.getBairro());
        animalDTO.setCidade(this.usuario.getCidade());
        animalDTO.setUf(this.usuario.getUf());

        return animalDTO;
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
        public static final String DOAR = "DOAR";
    }
}

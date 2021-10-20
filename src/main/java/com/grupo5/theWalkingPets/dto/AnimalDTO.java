package com.grupo5.theWalkingPets.dto;

import com.grupo5.theWalkingPets.entity.Animal;
import com.grupo5.theWalkingPets.entity.Foto;
import com.grupo5.theWalkingPets.entity.Usuario;
import com.grupo5.theWalkingPets.enumx.Especie;
import com.grupo5.theWalkingPets.enumx.Porte;
import com.grupo5.theWalkingPets.enumx.Sexo;
import com.grupo5.theWalkingPets.enumx.Temperamento;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    private MultipartFile foto;


    private String fotoBase64;

    //dados vindos do dono
    private String bairro;
    private String uf;
    private String cidade;


    public AnimalDTO() {
    }

    public AnimalDTO(Long id, String nome, Especie especie, String raca, Sexo sexo, String idade, String pelagem, Porte porte, Temperamento temperamento, boolean castrado, boolean vacinado, boolean perdido, String anilha, MultipartFile foto, String bairro, String uf, String cidade) {
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
        this.bairro = bairro;
        this.uf = uf;
        this.cidade = cidade;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }


    public boolean isValid(){
        return this.anilha != null && this.nome != null && this.raca != null && this.idade != null && this.pelagem != null && this.porte != null && this.temperamento != null && this.especie != null ;
    }

    public Animal converterToAnimal(Usuario usuario) throws IOException {
        Animal animal = new Animal();
        animal.setAnilha(this.anilha);
        animal.setCastrado(this.castrado);
        animal.setEspecie(this.especie);
        animal.setIdade(this.idade);
        animal.setNome(this.nome);
        animal.setSexo(this.sexo);
        animal.setVacinado(this.vacinado);
        animal.setRaca(this.raca);
        animal.setTemperamento(this.temperamento);
        animal.setPerdido(this.perdido);
        animal.setPorte(this.porte);
        animal.setPelagem(this.pelagem);
        animal.setDoar(true);

        if(this.foto != null){
            animal.setFoto(new Foto(this.foto.getOriginalFilename(),this.foto.getContentType(), BlobProxy.generateProxy(this.foto.getBytes())));
        }

        animal.setUsuario(usuario);

        return animal;
    }
}

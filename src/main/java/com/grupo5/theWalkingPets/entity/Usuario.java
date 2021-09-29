package com.grupo5.theWalkingPets.entity;

import com.grupo5.theWalkingPets.util.ConversaoUtil;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "usuario")
public class Usuario  implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Colunas.ID)
    private Long id;

    @Column(name = Colunas.NOME)
    private String nome;

    @Column(name = Colunas.EMAIL)
    private String email;

    @Column(name = Colunas.SENHA)
    private String senha;

    @Column(name = Colunas.BAIRRO)
    private String bairro;//Converter para objeto ?

    @Column(name = Colunas.TELEFONE)
    private String telefone;//Converter para objeto ?

    @Column(name = Colunas.VERIFICADO)
    private Boolean verificado;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(
            name = "usuarios_permissoes",
            joinColumns = @JoinColumn(
                    name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "permissao_id", referencedColumnName = "id"))
    private Collection<Permissao> permissoes;

    public Usuario(Long id, String nome, String email, String senha, String bairro, String telefone, Boolean verificado) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.bairro = bairro;
        this.telefone = telefone;
        this.verificado = verificado;
    }

    public Usuario(String nome, String email, String senha, String bairro, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.bairro = bairro;
        this.telefone = telefone;
        this.verificado = false;
    }

    public Usuario() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    public void changePassword() {
        this.senha = ConversaoUtil.encode(this.senha);
    }

    public boolean validForLogin(){
        return this.senha != null && this.email != null;
    }

    public Collection<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Collection<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissoes;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static class Colunas{
            public static final String ID = " ID";
            public static final String NOME = "NOME";
            public static final String EMAIL = "EMAIL";
            public static final String SENHA = "SENHA";
            public static final String BAIRRO = "BAIRRO";
            public static final String TELEFONE = "TELEFONE";
            public static final String VERIFICADO = "VERIFICADO";
    }
}

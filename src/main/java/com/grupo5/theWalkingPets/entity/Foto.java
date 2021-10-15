package com.grupo5.theWalkingPets.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Lob
    private Blob data;

    public Foto() {
    }

    public Foto(String name, String type, Blob data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public Foto(Long id, String name, String type, Blob data) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Blob getData() {
        return data;
    }

    public void setData(Blob data) {
        this.data = data;
    }
}

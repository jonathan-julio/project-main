package com.jonathan.springmvcapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String texto;
    private String textoSecundario;
    @Column(length = 4000)
    private String about;
    private String color;
    private String background;
    public Profile() {
    }
    public Profile(Integer id, String texto, String textoSecundario, String about, String color, String background) {
        this.id = id;
        this.texto = texto;
        this.textoSecundario = textoSecundario;
        this.about = about;
        this.color = color;
        this.background = background;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getTextoSecundario() {
        return textoSecundario;
    }
    public void setTextoSecundario(String textoSecundario) {
        this.textoSecundario = textoSecundario;
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getBackground() {
        return background;
    }
    public void setBackground(String background) {
        this.background = background;
    }
    @Override
    public String toString() {
        return "Perfil [id=" + id + ", texto=" + texto + ", textoSecundario=" + textoSecundario + ", about=" + about
                + ", color=" + color + ", background=" + background + "]";
    }
    
}

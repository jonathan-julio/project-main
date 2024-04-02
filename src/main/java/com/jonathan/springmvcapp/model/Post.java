package com.jonathan.springmvcapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer id;
    private String img;
    private String descricao;
    private List<Integer> usuarios;

    public Post() {
    }
    public Post(Integer id, String img, String descricao, List<Integer> usuarios) {
        this.id = id;
        this.img = img;
        this.descricao = descricao;
        this.usuarios = usuarios;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public List<Integer> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Integer> usuarios) {
        this.usuarios = usuarios;
    }
    @Override
    public String toString() {
        return "Post [id=" + id + ", img=" + img + ", descricao=" + descricao + ", usuarios=" + usuarios + "]";
    }
    
}

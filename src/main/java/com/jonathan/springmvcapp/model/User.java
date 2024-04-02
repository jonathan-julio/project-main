package com.jonathan.springmvcapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class User {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String usuario;
    private String password;
    private String email;
    public User() {
    }
    public User(String usuario, String password, String email) {
        this.usuario = usuario;
        this.password = password;
        this.email = email;
    }
    public User(Integer id, String usuario, String password, String email) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", usuario=" + usuario + ", password=" + password + ", email=" + email + "]";
    }
    
}

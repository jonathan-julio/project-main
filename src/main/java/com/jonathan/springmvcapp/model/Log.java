package com.jonathan.springmvcapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private String function;
    private String changer;
    private String data;

    public Log() {
    }

    public Log(Integer userId, String function, String changer, String data) {
        this.userId = userId;
        this.function = function;
        this.changer = changer;
        this.data = data;
    }

    public Log(Integer id, Integer userId, String function, String changer, String data) {
        this.id = id;
        this.userId = userId;
        this.function = function;
        this.changer = changer;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getChanger() {
        return changer;
    }

    public void setChanger(String changer) {
        this.changer = changer;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Log [id=" + id + ", userId=" + userId + ", function=" + function + ", changer=" + changer + ", data="
                + data + "]";
    }

}

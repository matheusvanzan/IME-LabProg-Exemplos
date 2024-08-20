package com.example.labprog.Demo;

public class User {

    private Integer id;
    private String name;
    private String email;

    public User(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String nome) {
        this.name = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

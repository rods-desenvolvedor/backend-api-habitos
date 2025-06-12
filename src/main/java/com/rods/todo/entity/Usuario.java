package com.rods.todo.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {


    public Usuario() {}

    

    public Usuario(UUID id, String username, String email, String senha, LocalDate criadoEm) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.criadoEm = criadoEm;
    }

    public Usuario(String username, String email, String senha, LocalDate criadoEm) {
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.criadoEm = criadoEm;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String username;

    private String email;

    private String senha;

    private LocalDate criadoEm;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }

    
    
}

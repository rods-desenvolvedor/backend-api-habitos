package com.rods.todo.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_habitos")
public class Habito {

    public Habito() {}

    

    public Habito(UUID id, String titulo, String descricao, LocalDate dataUltimoStreak, int contagemStreak) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataUltimoStreak = dataUltimoStreak;
        this.contagemStreak = contagemStreak;
    }


    public Habito(String titulo, String descricao, LocalDate dataUltimoStreak, int contagemStreak) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataUltimoStreak = dataUltimoStreak;
        this.contagemStreak = contagemStreak;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;

    private String descricao;

    private LocalDate dataUltimoStreak;

    private int contagemStreak;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataUltimoStreak() {
        return dataUltimoStreak;
    }

    public void setDataUltimoStreak(LocalDate dataUltimoStreak) {
        this.dataUltimoStreak = dataUltimoStreak;
    }

    public int getContagemStreak() {
        return contagemStreak;
    }

    public void setContagemStreak(int contagemStreak) {
        this.contagemStreak = contagemStreak;
    }

    
    
}

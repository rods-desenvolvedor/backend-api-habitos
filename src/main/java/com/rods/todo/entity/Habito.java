package com.rods.todo.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_habitos")
public class Habito {

    public Habito() {}

    

    public Habito(UUID id, String titulo, String descricao, LocalDate dataUltimoStreak, int contagemStreak, LocalDate criadoEm) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataUltimoStreak = dataUltimoStreak;
        this.contagemStreak = contagemStreak;
        this.criadoEm = criadoEm;
    }


    public Habito(String titulo, String descricao, LocalDate dataUltimoStreak, int contagemStreak, LocalDate criadoEm) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataUltimoStreak = dataUltimoStreak;
        this.contagemStreak = contagemStreak;
        this.criadoEm = criadoEm;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;

    private String descricao;

    @Column(name = "data_ultimo_streak")
    private LocalDate dataUltimoStreak;

    @Column(name = "contagem_streak")
    private int contagemStreak;

    @Column(name = "criado_em")
    private LocalDate criadoEm;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    

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

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
}

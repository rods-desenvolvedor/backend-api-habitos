package com.rods.todo.dtos.habito;

import java.time.LocalDate;

import com.rods.todo.entity.Habito;

public record HabitoResponseDto(String titulo, String descricao, int contagemStreak , LocalDate dataUltimoStreak) {

    public HabitoResponseDto(Habito habito)
    {
        this(habito.getTitulo(), habito.getDescricao(), habito.getContagemStreak(), habito.getDataUltimoStreak());
    }
    
}

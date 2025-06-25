package com.rods.todo.dtos.habito;

import jakarta.validation.constraints.NotBlank;

public record HabitoRequestDto(
    
    @NotBlank(message = "O titulo não pode ficar em branco")
    String titulo,

    @NotBlank(message = "A descrição do habito não pode ficar em branco")
    String descricao) {
    
}

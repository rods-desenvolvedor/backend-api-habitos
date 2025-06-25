package com.rods.todo.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthRequestDto(
    
    @Email
    @NotBlank
    String email,

    @NotBlank
    @Size(min = 6, message = "Senha deve ter no minimo 6 caracteres")
    String senha) {
    
}

package com.rods.todo.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterDto(

    @NotBlank
    @Size(min = 3, message = "username deve ter pelo menos 3 caracteres")
    String username,

    @Email
    @NotBlank
    String email,

    @NotBlank
    @Size(min = 6, message = "senha deve ter pelo menos 6 caracteres")
    String senha
) {
    
}

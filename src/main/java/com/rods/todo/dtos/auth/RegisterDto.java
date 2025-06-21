package com.rods.todo.dtos.auth;

public record RegisterDto(

    String username,
    String email,
    String senha
) {
    
}

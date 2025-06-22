package com.rods.todo.dtos.auth;

public record LoginResponseDto(String token, long expiresIn) {
    
}

package com.rods.todo.exception;

public class UsuarioJaExisteException extends RuntimeException{

    public UsuarioJaExisteException(String email)
    {
        super("Já existe um usuário cadastrado com o seguinte email: " + email);
    }
    
}

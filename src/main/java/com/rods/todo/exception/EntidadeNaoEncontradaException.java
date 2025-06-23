package com.rods.todo.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

    public EntidadeNaoEncontradaException(String entidade, Object id)
    {
        super(entidade + " com identificador [" + id + "] não foi encontrada.");
    }
    
}

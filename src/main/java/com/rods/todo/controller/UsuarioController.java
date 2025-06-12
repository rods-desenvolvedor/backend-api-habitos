package com.rods.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rods.todo.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService)
    {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/teste")
    public ResponseEntity<String> teste()
    {
        return ResponseEntity.ok().body("ok: teste bem sucedido.");
    }
    
}

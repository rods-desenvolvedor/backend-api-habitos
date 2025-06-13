package com.rods.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rods.todo.dtos.usuario.UsuarioRequestDto;
import com.rods.todo.dtos.usuario.UsuarioResponseDto;
import com.rods.todo.entity.Usuario;
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

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponseDto> cadastrarUsuario(@RequestBody UsuarioRequestDto usuarioRequestDto)
    {
        UsuarioResponseDto usuarioResponseDto = usuarioService.cadastrarUsuario(usuarioRequestDto);

        return ResponseEntity.ok().body(usuarioResponseDto);
    }
    
}

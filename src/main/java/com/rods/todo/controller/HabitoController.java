package com.rods.todo.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rods.todo.dtos.habito.HabitoRequestDto;
import com.rods.todo.dtos.habito.HabitoResponseDto;
import com.rods.todo.service.HabitoService;

@RestController
@RequestMapping("/api/habito")
public class HabitoController {

    private HabitoService habitoService;

    public HabitoController(HabitoService habitoService)
    {
        this.habitoService = habitoService;
    }

    @PostMapping("/cadastrar/{id}")
    public ResponseEntity<HabitoResponseDto> cadastrarHabito(@RequestBody HabitoRequestDto habitoRequestDto, @PathVariable UUID id)
    {
        HabitoResponseDto habito = habitoService.cadastrarHabito(habitoRequestDto, id);

        return ResponseEntity.ok().body(habito);
    }
    
}

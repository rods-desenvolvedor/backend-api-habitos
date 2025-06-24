package com.rods.todo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PatchMapping("/atualizar/aumentar-streak/{id}")
    public ResponseEntity<HabitoResponseDto> aumentarStreakDeUmHabito(@PathVariable UUID id)
    {
        HabitoResponseDto habito = habitoService.aumentarStreakDeUmHabito(id);

        return ResponseEntity.ok().body(habito);
    }

    @PostMapping("/cadastrar/{id}")
    public ResponseEntity<HabitoResponseDto> cadastrarHabito(@RequestBody HabitoRequestDto habitoRequestDto, @PathVariable UUID id)
    {
        HabitoResponseDto habito = habitoService.cadastrarHabito(habitoRequestDto, id);

        return ResponseEntity.ok().body(habito);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<List<HabitoResponseDto>> listarHabitos(@PathVariable UUID id)
    {
        List<HabitoResponseDto> habitos = habitoService.listarHabitos(id);
        return ResponseEntity.ok().body(habitos);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<HabitoResponseDto> autualizarHabito(@RequestBody HabitoRequestDto habitoRequestDto, @PathVariable UUID id)
    {
        HabitoResponseDto habitoAtualizado = habitoService.atualizarHabito(id, habitoRequestDto);

        return ResponseEntity.ok().body(habitoAtualizado);
    }    

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> apagarHabito(@PathVariable UUID id)
    {
        habitoService.apagarHabitoPeloId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

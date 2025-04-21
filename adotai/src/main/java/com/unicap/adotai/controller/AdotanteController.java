package com.unicap.adotai.controller;

import com.unicap.adotai.dto.AdotanteDTO;
import com.unicap.adotai.model.Adotante;
import com.unicap.adotai.service.AdotanteService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adotantes")
public class AdotanteController {

    private AdotanteService service;

    @PostMapping
    public ResponseEntity<String> criar(@Valid @RequestBody AdotanteDTO dto) {
        try {
            Adotante adotante = service.salvar(dto);
            return ResponseEntity.ok("Adotante criado com sucesso: " + adotante.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao criar adotante: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Adotante>> listarTodos() {
        List<Adotante> adotantes = service.listarTodos();
        if (adotantes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(adotantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adotante> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).<Adotante>build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.ok("Adotante com ID " + id + " foi deletado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Erro ao deletar adotante: " + e.getMessage());
        }
    }
}
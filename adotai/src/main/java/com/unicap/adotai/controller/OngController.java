package com.unicap.adotai.controller;

import com.unicap.adotai.dto.OngDTO;
import com.unicap.adotai.model.Ong;
import com.unicap.adotai.service.OngService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ongs")
public class OngController {

    private final OngService service;

    public OngController(OngService service) {
        this.service = service;
    }

    @PostMapping("/criar")
    public ResponseEntity<Ong> criar(@RequestBody @Valid OngDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Ong>> listar() {
        List<Ong> ongs = service.listarTodas();
        if (ongs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ongs);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Ong> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
package com.unicap.adotai.controller;


import com.unicap.adotai.dto.AnimalDTO;
import com.unicap.adotai.model.Animal;
import com.unicap.adotai.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<Animal> criar(@RequestBody AnimalDTO dto) {
        try {
            Animal animal = animalService.salvar(dto); 
            if (animal != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(animal); // Retorna o animal com status 201 (Criado)
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Retorna erro caso o animal não tenha sido salvo
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Animal>> listar() {
        List<Animal> animais = animalService.listarTodos();
        if (animais.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 se não houver animais
        }
        return ResponseEntity.ok(animais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable Long id) {
        return animalService.buscarPorId(id)
                .map(ResponseEntity::ok) 
                .orElse(ResponseEntity.notFound().build()); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            animalService.deletar(id); 
            return ResponseEntity.noContent().build(); // Retorna 204 se deletado
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // Retorna 404 se o animal não existir ou ocorrer erro
        }
    }
}
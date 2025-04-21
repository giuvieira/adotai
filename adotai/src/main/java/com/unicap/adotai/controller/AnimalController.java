package com.unicap.adotai.controller;

import com.unicap.adotai.dto.AnimalDTO;
import com.unicap.adotai.model.Animal;
import com.unicap.adotai.service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private AnimalService animalService;

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Animal> criar(@Valid @RequestBody AnimalDTO dto) {
        try {
            Animal animal = animalService.salvar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(animal);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Animal>> listar() {
        try {
            List<Animal> animais = animalService.listarTodos();
            if (animais.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(animais);
        } catch (Exception e) {
            // Logando o erro para rastrear a causa
            e.printStackTrace();  // Você pode usar o log de sua preferência aqui
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(List.of());  // Retorna uma resposta adequada com a mensagem de erro
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<String> buscarPorId(@PathVariable Long id) {
        try {
            return animalService.buscarPorId(id)
                    .map(animal -> ResponseEntity.ok(animal.toString()))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar o animal.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            animalService.deletar(id);
            return ResponseEntity.noContent().build(); 
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // Mensagem de erro detalhada
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o animal.");
        }
    }
}
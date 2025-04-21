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
    public ResponseEntity<String> criar(@Valid @RequestBody AnimalDTO dto) {
        try {
            animalService.salvar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Animal criado com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro nos dados fornecidos: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar o animal.");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<Object> listar() {
        try {
            List<Animal> animais = animalService.listarTodos();
            if (animais.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nenhum animal encontrado.");
            }
            return ResponseEntity.status(HttpStatus.OK).body(animais);
        } catch (Exception e) {
            // Logando o erro para rastrear a causa
            e.printStackTrace(); 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao listar os animais.");
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
            return ResponseEntity.ok("Animal deletado com sucesso."); 
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // Mensagem de erro detalhada
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o animal.");
        }
    }
}
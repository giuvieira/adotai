package com.unicap.adotai.controller;

import com.unicap.adotai.dto.AdocaoDTO;
import com.unicap.adotai.model.Adocao;
import com.unicap.adotai.service.AdocaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adocoes")
public class AdocaoController {

    private AdocaoService adocaoService;

    @PostMapping
    public Adocao criarAdocao(@RequestBody AdocaoDTO dto) {
        return adocaoService.salvar(dto);
    }

    @GetMapping
    public List<Adocao> listar() {
        return adocaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Adocao> buscarPorId(@PathVariable Integer id) {
        return adocaoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        adocaoService.deletar(id);
    }
}
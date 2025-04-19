package com.unicap.adotai.service;

import com.unicap.adotai.dto.AdotanteDTO;
import com.unicap.adotai.model.Adotante;
import com.unicap.adotai.repository.AdotanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdotanteService {

    @Autowired
    private AdotanteRepository repository;

    public Adotante salvar(AdotanteDTO dto) {
        Adotante adotante = new Adotante();
        adotante.setNome(dto.getNome());
        adotante.setDtnascimento(dto.getDtnascimento());
        adotante.setCpfCnpj(dto.getCpfCnpj());
        adotante.setEmail(dto.getEmail());
        adotante.setSenha(dto.getSenha());
        adotante.setTelefone(dto.getTelefone());

        return repository.save(adotante);
    }

    public List<Adotante> listarTodos() {
        return repository.findAll();
    }

    public Optional<Adotante> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

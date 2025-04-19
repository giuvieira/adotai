package com.unicap.adotai.service;

import com.unicap.adotai.dto.OngDTO;
import com.unicap.adotai.model.Ong;
import com.unicap.adotai.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OngService {

    @Autowired
    private OngRepository repository;

    public Ong salvar(OngDTO dto) {
        Ong ong = new Ong();
        ong.setNome(dto.getNome());
        ong.setDtnascimento(dto.getDtnascimento());
        ong.setCpfCnpj(dto.getCpfCnpj());
        ong.setEmail(dto.getEmail());
        ong.setSenha(dto.getSenha());
        ong.setTelefone(dto.getTelefone());

        ong.setEndereco(dto.getEndereco());
        ong.setIdAnimais(dto.getIdAnimais());
        ong.setDescricaoAnimais(dto.getDescricaoAnimais());


    return repository.save(ong);
    }

    public List<Ong> listarTodas() {
        return repository.findAll();
    }

    public Optional<Ong> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
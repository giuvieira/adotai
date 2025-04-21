package com.unicap.adotai.service;


import com.unicap.adotai.dto.AdocaoDTO;
import com.unicap.adotai.model.Adotante;
import com.unicap.adotai.model.Adocao;
import com.unicap.adotai.model.Animal;
import com.unicap.adotai.repository.AdocaoRepository;
import com.unicap.adotai.repository.AdotanteRepository;
import com.unicap.adotai.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdocaoService {

    private AdocaoRepository adocaoRepository;
    private AdotanteRepository adotanteRepository;
    private AnimalRepository animalRepository;

    public Adocao salvar(AdocaoDTO dto) {
        Adocao adocao = new Adocao();

        Optional<Adotante> adotanteOpt = adotanteRepository.findById(dto.getAdotanteId());
        Optional<Animal> animalOpt = animalRepository.findById(dto.getAnimalId());

        if (adotanteOpt.isPresent() && animalOpt.isPresent()) {
            adocao.setAdotante(adotanteOpt.get());
            adocao.setAnimal(animalOpt.get());
        } else {
            throw new RuntimeException("Adotante ou Animal não encontrado");
        }

        adocao.setAdocCpf(dto.getAdocCpf());
        adocao.setAdocEnduser(dto.getAdocEnduser());
        adocao.setAdocData(dto.getAdocData());
        adocao.setAdocObservacao(dto.getAdocObservacao());
        adocao.setAdocStatus(dto.getAdocStatus());

        return adocaoRepository.save(adocao);
    }

    public List<Adocao> listarTodos() {
        return adocaoRepository.findAll();
    }

    public Optional<Adocao> buscarPorId(Integer id) {
        return adocaoRepository.findById(id);
    }

    public void deletar(Integer id) {
        adocaoRepository.deleteById(id);
    }
}
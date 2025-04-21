package com.unicap.adotai.service;

import com.unicap.adotai.dto.AnimalDTO;
import com.unicap.adotai.model.Animal;
import com.unicap.adotai.model.Ong;
import com.unicap.adotai.repository.AnimalRepository;
import com.unicap.adotai.repository.OngRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;
    private OngRepository ongRepository;

    public Animal salvar(AnimalDTO dto) {
        Animal animal = new Animal();
        animal.setNome(dto.getNome());
        animal.setEspecie(dto.getEspecie());
        animal.setIdade(dto.getIdade());
        animal.setSexo(dto.getSexo());
        animal.setDtEntrada(dto.getDtEntrada());
        animal.setCastrado(dto.isCastrado());

        if (dto.getOngId() != null) {
            Optional<Ong> ongOptional = ongRepository.findById(dto.getOngId());
            ongOptional.ifPresent(animal::setOng);
        }

        return animalRepository.save(animal);
    }

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public Optional<Animal> buscarPorId(Long id) {
        return animalRepository.findById(id);
    }

    public void deletar(Long id) {
        animalRepository.deleteById(id);
    }
}

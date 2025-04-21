package com.unicap.adotai.service;

import com.unicap.adotai.dto.AnimalDTO;
import com.unicap.adotai.model.Animal;
import com.unicap.adotai.model.Ong;
import com.unicap.adotai.repository.AnimalRepository;
import com.unicap.adotai.repository.OngRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final OngRepository ongRepository;

    public AnimalService(AnimalRepository animalRepository, OngRepository ongRepository) {
        this.animalRepository = animalRepository;
        this.ongRepository = ongRepository;
    }

    @Transactional
    public Animal salvar(AnimalDTO dto) {
        validarAnimalDTO(dto);

        Animal animal = new Animal();
        animal.setNome(dto.getNome());
        animal.setEspecie(dto.getEspecie());
        animal.setIdade(dto.getIdade());
        animal.setSexo(dto.getSexo());
        animal.setDtEntrada(dto.getDtEntrada());
        animal.setCastrado(dto.isCastrado());

        if (dto.getOngId() != null) {
            Ong ong = ongRepository.findById(dto.getOngId())
                    .orElseThrow(() -> new IllegalArgumentException("ONG não encontrada com ID: " + dto.getOngId()));
            animal.setOng(ong);
        }

        return animalRepository.save(animal);
    }

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public Optional<Animal> buscarPorId(Long id) {
        return animalRepository.findById(id);
    }

    @Transactional
    public void deletar(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new IllegalArgumentException("Animal não encontrado com ID: " + id);
        }
        animalRepository.deleteById(id);
    }

    private void validarAnimalDTO(AnimalDTO dto) {
        if (dto.getNome() == null || dto.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do animal é obrigatório.");
        }
        if (dto.getEspecie() == null || dto.getEspecie().isEmpty()) {
            throw new IllegalArgumentException("A espécie do animal é obrigatória.");
        }
        if (Integer.valueOf(dto.getIdade()) == null || dto.getIdade() < 0) {
            throw new IllegalArgumentException("A idade do animal deve ser válida.");
        }
    }
}

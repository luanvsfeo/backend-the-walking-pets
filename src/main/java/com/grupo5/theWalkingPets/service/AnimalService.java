package com.grupo5.theWalkingPets.service;

import com.grupo5.theWalkingPets.dto.AnimalDTO;
import com.grupo5.theWalkingPets.entity.Animal;
import com.grupo5.theWalkingPets.entity.Usuario;
import com.grupo5.theWalkingPets.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void salvar(Animal animal){
        animalRepository.save(animal);
    }

    public List<AnimalDTO> buscarPorFiltro(){
        return converterParaDTO(animalRepository.findAllByDoarTrue());
    }

    public List<AnimalDTO> buscarMeusAnimais(Usuario usuario){
        return converterParaDTO(animalRepository.findAllByUsuario(usuario));
    }


    private List<AnimalDTO> converterParaDTO(List<Animal> animals){
       List<AnimalDTO> animalDTOS =  new ArrayList<>();

       for(Animal animal : animals){
           animalDTOS.add(animal.converterParaDTO());
       }
        return animalDTOS;
    }
}

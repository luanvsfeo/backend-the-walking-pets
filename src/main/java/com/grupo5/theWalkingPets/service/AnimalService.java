package com.grupo5.theWalkingPets.service;

import com.grupo5.theWalkingPets.entity.Animal;
import com.grupo5.theWalkingPets.repository.AnimalRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void salvar(Animal animal){
        animalRepository.save(animal);
    }

    public void buscarPorFiltro(){

    }



}

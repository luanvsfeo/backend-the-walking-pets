package com.grupo5.theWalkingPets.controller;

import com.grupo5.theWalkingPets.dto.AnimalDTO;
import com.grupo5.theWalkingPets.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/adocao")
    public ResponseEntity<?> adocao(){
        //TODO - Listagem de animais de outros usuarios


        return ResponseEntity.ok("ok");
    }

    @GetMapping("/doacao")
    public ResponseEntity<?> doacao(){
        //TODO - Listagem dos seus animais

        return ResponseEntity.ok("ok");
    }

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody AnimalDTO animalDTO){
        //TODO -  cadastro um animal associado ao usuario

        animalService.salvar(animalDTO.converterToAnimal());

        return ResponseEntity.ok("ok");
    }

    @PutMapping
    public ResponseEntity<?> atualizacao(@RequestBody AnimalDTO animalDTO){
        //TODO - atualiza um animal em especifico

        animalService.salvar(animalDTO.converterToAnimal());


        return ResponseEntity.ok("ok");
    }
}

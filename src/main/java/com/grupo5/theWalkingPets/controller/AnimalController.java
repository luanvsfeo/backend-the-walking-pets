package com.grupo5.theWalkingPets.controller;

import com.grupo5.theWalkingPets.dto.AnimalDTO;
import com.grupo5.theWalkingPets.entity.Usuario;
import com.grupo5.theWalkingPets.service.AnimalService;
import com.grupo5.theWalkingPets.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;

    private final UsuarioService usuarioService;

    public AnimalController(AnimalService animalService, UsuarioService usuarioService) {
        this.animalService = animalService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/perdidos")
    public ResponseEntity<?> perdidos(){
        //TODO - Listagem de animais com flag de perdido como true
        return ResponseEntity.ok().body(animalService.buscarPerdidos());
    }

    @GetMapping("/adocao")
    public ResponseEntity<?> adocao(){
        //TODO - Listagem de animais de outros usuarios
        return ResponseEntity.ok().body(animalService.buscarPorFiltro());
    }

    @GetMapping("/doacao")
    public ResponseEntity<?> doacao(HttpServletRequest request){
        //TODO - Listagem dos seus animais

        Usuario user = usuarioService.buscarUsuarioPorToken(request.getHeader("Authorization"));

        return ResponseEntity.ok().body(animalService.buscarMeusAnimais(user));
    }

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody AnimalDTO animalDTO, HttpServletRequest request){
        //TODO -  cadastro um animal associado ao usuario

        Usuario user = usuarioService.buscarUsuarioPorToken(request.getHeader("Authorization"));

        animalService.salvar(animalDTO.converterToAnimal(user));

        return ResponseEntity.ok("ok");
    }

    @PutMapping
    public ResponseEntity<?> atualizacao(@RequestBody AnimalDTO animalDTO, HttpServletRequest request){
        //TODO - atualiza um animal em especifico

        Usuario user = usuarioService.buscarUsuarioPorToken(request.getHeader("Authorization"));

        animalService.salvar(animalDTO.converterToAnimal(user));


        return ResponseEntity.ok("ok");
    }
}

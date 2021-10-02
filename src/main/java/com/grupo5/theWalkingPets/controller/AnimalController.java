package com.grupo5.theWalkingPets.controller;

import com.grupo5.theWalkingPets.dto.AnimalDTO;
import com.grupo5.theWalkingPets.entity.Usuario;
import com.grupo5.theWalkingPets.repository.UsuarioRepository;
import com.grupo5.theWalkingPets.service.AnimalService;
import com.grupo5.theWalkingPets.util.JwtTokenUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;

    private final UsuarioRepository usuarioRepository;

    private final JwtTokenUtil jwtTokenUtil;

    public AnimalController(AnimalService animalService, UsuarioRepository usuarioRepository, JwtTokenUtil jwtTokenUtil) {
        this.animalService = animalService;
        this.usuarioRepository = usuarioRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping("/adocao")
    public ResponseEntity<?> adocao(){
        //TODO - Listagem de animais de outros usuarios

        // TODO - FAZER SERVICE PARA FILTRO DE ANIMAIS COM IMPL REPOSITORY
        return ResponseEntity.ok().body(animalService.buscarPorFiltro());
    }

    @GetMapping("/doacao")
    public ResponseEntity<?> doacao(HttpServletRequest request){
        //TODO - Listagem dos seus animais

        final String requestTokenHeader = request.getHeader("Authorization");

        Usuario user = usuarioRepository.findByEmail(jwtTokenUtil.getUsernameFromToken(requestTokenHeader.substring(7)));

        return ResponseEntity.ok().body(animalService.buscarMeusAnimais(user));
    }

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody AnimalDTO animalDTO, HttpServletRequest request){
        //TODO -  cadastro um animal associado ao usuario

        final String requestTokenHeader = request.getHeader("Authorization");

        Usuario user = usuarioRepository.findByEmail(jwtTokenUtil.getUsernameFromToken(requestTokenHeader.substring(7)));

        animalService.salvar(animalDTO.converterToAnimal(user));

        return ResponseEntity.ok("ok");
    }

    @PutMapping
    public ResponseEntity<?> atualizacao(@RequestBody AnimalDTO animalDTO, HttpServletRequest request){
        //TODO - atualiza um animal em especifico

        final String requestTokenHeader = request.getHeader("Authorization");

        Usuario user = usuarioRepository.findByEmail(jwtTokenUtil.getUsernameFromToken(requestTokenHeader.substring(7)));

        animalService.salvar(animalDTO.converterToAnimal(user));


        return ResponseEntity.ok("ok");
    }
}

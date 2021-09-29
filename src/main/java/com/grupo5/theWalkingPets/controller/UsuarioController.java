package com.grupo5.theWalkingPets.controller;

import com.grupo5.theWalkingPets.dto.UsuarioDTO;
import com.grupo5.theWalkingPets.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/criacao")
    public ResponseEntity<?> create(@RequestBody UsuarioDTO usuarioDTO){

        if(!usuarioDTO.isValid()){
             return ResponseEntity.badRequest().body("Campo faltando");
        }

        if(usuarioService.criarUsuarioPessoaFisica(usuarioDTO.converterParaUsuario()) == null){
            return ResponseEntity.badRequest().body("Email ja existente");
        }

        return ResponseEntity.ok("Usuario criado");
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO usuarioDTO){

        final String token = usuarioService.generateToken(usuarioDTO.converterParaUsuario());

        if(token != null){
            return ResponseEntity.ok(token);
        }else{
            return ResponseEntity.badRequest().body("Ocorreu um erro ao logar");
        }

        // redirecionar para endpoint get de animais ou get inicial de usuario com o header de authorization(front ou back ?)

    }


    @PostMapping("/verificar")
    public ResponseEntity<?> verificar(){
        //PRECISA DE AUTHORIZATION
        // altera a flag de verificado para true


        return ResponseEntity.ok("");
    }


    @GetMapping("/primeiros-passos")
    public ResponseEntity<?> inicio(){
        //PRECISA DE AUTHORIZATION
        // telas iniciais do app ?

        return ResponseEntity.ok("foi meu nobre");
    }
}

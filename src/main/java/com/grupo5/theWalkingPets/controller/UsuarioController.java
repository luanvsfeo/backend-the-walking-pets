package com.grupo5.theWalkingPets.controller;

import com.grupo5.theWalkingPets.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @PostMapping
    public ResponseEntity<?> create(@RequestParam("usuario") UsuarioDTO usuarioDTO){

        // cria o usuario :D

        return ResponseEntity.ok("");
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("email") String email,@RequestParam("senha")String senha){

        // autenticar o email e a senha com o que esta no banco
        // gerar jwt e retornar
        // redirecionar para endpoint get de animais ou get inicial de usuario com o header de authorization(front ou back ?)

        return ResponseEntity.ok("");
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

        return ResponseEntity.ok("");
    }
}

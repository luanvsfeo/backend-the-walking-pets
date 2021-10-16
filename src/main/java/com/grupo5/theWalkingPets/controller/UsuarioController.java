package com.grupo5.theWalkingPets.controller;

import com.grupo5.theWalkingPets.dto.UsuarioDTO;
import com.grupo5.theWalkingPets.dto.ViaCepDTO;
import com.grupo5.theWalkingPets.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/criacao")
    public ResponseEntity<?> create(@RequestBody UsuarioDTO usuarioDTO) {

        try{
            if (!usuarioDTO.isValid()) {
                return ResponseEntity.badRequest().body("Campo faltando");
            }

            String viaCep = "https://viacep.com.br/ws/" + usuarioDTO.getCep() + "/json/";

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<ViaCepDTO> response  = restTemplate.getForEntity(viaCep, ViaCepDTO.class);

            if(Objects.requireNonNull(response.getBody()).getCep() == null){
                return ResponseEntity.badRequest().body("Cep invalido");
            }

            // TODO - Incluir criação de usuario pessoa juridica
            if (usuarioService.criarUsuario(usuarioDTO, response.getBody()) == null) {
                return ResponseEntity.badRequest().body("Email ja existente");
            }

            return ResponseEntity.ok("Usuario criado");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getClass());
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO usuarioDTO) {

        final String token = usuarioService.generateToken(usuarioDTO.converterParaUsuario());

        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.badRequest().body("Ocorreu um erro ao logar");
        }

        // redirecionar para endpoint get de animais ou get inicial de usuario com o header de authorization(front ou back ?)
    }


    @PostMapping("/verificar")
    public ResponseEntity<?> verificar() {
        //Procurar serviço gratis de envio de email ?
        // TODO - altera a flag de verificado para true

        return ResponseEntity.ok("");
    }


    @GetMapping("/primeiros-passos")
    public ResponseEntity<?> inicio() {
        //PRECISA DE AUTHORIZATION
        // telas iniciais do app ?
        return ResponseEntity.ok("foi meu nobre");
    }
}

package com.grupo5.theWalkingPets.controller;

import com.grupo5.theWalkingPets.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    private final UsuarioService usuarioService;

    public ServicoController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<?> listagem(String cidade){
        //TODO - buscar os serviços(usuarios - pessoa juridica da mesma cidade)
        return ResponseEntity.ok(usuarioService.buscarUsuariosJuridicosPorCidade(cidade));
    }
}

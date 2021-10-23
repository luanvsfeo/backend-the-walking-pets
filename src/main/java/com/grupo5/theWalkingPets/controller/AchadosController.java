package com.grupo5.theWalkingPets.controller;

import com.grupo5.theWalkingPets.dto.AchadosDTO;
import com.grupo5.theWalkingPets.entity.Usuario;
import com.grupo5.theWalkingPets.service.AchadosService;
import com.grupo5.theWalkingPets.service.UsuarioService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/achados")
public class AchadosController {

    private final AchadosService achadosService;

    private final UsuarioService usuarioService;

    public AchadosController(AchadosService achadosService, UsuarioService usuarioService) {
        this.achadosService = achadosService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<?> listagemPorCidade(String cidade) {
          // TODO - Listagem com base na cidade atual (coordenadas)
        return ResponseEntity.ok(achadosService.buscarPorCidade(cidade));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> criacao(@RequestParam("foto") MultipartFile foto, AchadosDTO achadosDTO, HttpServletRequest request) {

        Usuario user = usuarioService.buscarUsuarioPorToken(request.getHeader("Authorization"));

        //TODO - Pegar localização atual - vinda do front e converter para bairro, cidade e uf ?

        if(!achadosDTO.isValid()){
            return ResponseEntity.badRequest().body("Campo faltante");
        }

        achadosService.salvar(achadosDTO.converterParaAchados(),foto,user);

        return ResponseEntity.ok("Criado com sucesso");
    }
}

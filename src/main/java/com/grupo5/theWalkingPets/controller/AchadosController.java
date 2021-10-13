package com.grupo5.theWalkingPets.controller;

import com.grupo5.theWalkingPets.dto.AchadosDTO;
import com.grupo5.theWalkingPets.service.AchadosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/achados")
public class AchadosController {

    private final AchadosService achadosService;

    public AchadosController(AchadosService achadosService) {
        this.achadosService = achadosService;
    }

    @GetMapping
    public ResponseEntity<?> listagem() {
          // TODO - Listagem com base na cidade atual
        return ResponseEntity.ok(achadosService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<?> criacao(@RequestParam("foto")MultipartFile foto, AchadosDTO achadosDTO) {

        if(!achadosDTO.isValid()){
            return ResponseEntity.badRequest().body("Campo faltante");
        }

        achadosService.salvar(achadosDTO.converterParaAchados(),foto);

        return ResponseEntity.ok("Criado com sucesso");
    }
}

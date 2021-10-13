package com.grupo5.theWalkingPets.controller;

import com.grupo5.theWalkingPets.dao.filter.AnimalFilter;
import com.grupo5.theWalkingPets.dto.AnimalDTO;
import com.grupo5.theWalkingPets.entity.Usuario;
import com.grupo5.theWalkingPets.service.AnimalService;
import com.grupo5.theWalkingPets.service.UsuarioService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    public ResponseEntity<?> perdidos(@RequestParam("coordenadas") String coordenadas, HttpServletRequest request) {
        //TODO - mostrar apenas os animais perdidos com donos da mesma cidade e bairro
        Usuario user = usuarioService.buscarUsuarioPorToken(request.getHeader("Authorization"));

        return ResponseEntity.ok().body(animalService.buscarPerdidos(user));
    }

    @GetMapping("/adocao")
    public ResponseEntity<?> listagemAdoacao(@RequestBody(required = false) AnimalFilter animalFilter, HttpServletRequest request) {
        //TODO - mostrar apenas os da mesma cidade ?
        Usuario user = usuarioService.buscarUsuarioPorToken(request.getHeader("Authorization"));
        return ResponseEntity.ok().body(animalService.buscarPorFiltroParaListagem(animalFilter, user));
    }

    @PostMapping("/adocao")
    public ResponseEntity<?> pedidoAdocao() {
        //TODO - Aplicação para adocao
        return ResponseEntity.ok().body("me da o bicho ai");
    }

    @GetMapping("/doacao")
    public ResponseEntity<?> doacao(HttpServletRequest request) {

        Usuario user = usuarioService.buscarUsuarioPorToken(request.getHeader("Authorization"));
        return ResponseEntity.ok().body(animalService.buscarMeusAnimais(user));
    }

    @GetMapping("/doacao/pedidos")
    public ResponseEntity<?> listagemPedidosDeAdocao(HttpServletRequest request) {
        //TODO - Listagem dos pedidos de adoção para meus animais

        Usuario user = usuarioService.buscarUsuarioPorToken(request.getHeader("Authorization"));

        return ResponseEntity.ok().body(animalService.buscarMeusAnimais(user));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> cadastro(@RequestParam("foto") MultipartFile foto, AnimalDTO animalDTO, HttpServletRequest request) {
        try {

            Usuario user = usuarioService.buscarUsuarioPorToken(request.getHeader("Authorization"));
            animalService.salvar(animalDTO.converterToAnimal(user),foto);

            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getClass());
        }
    }

    @PutMapping
    public ResponseEntity<?> atualizacao(@RequestParam("foto") MultipartFile foto,AnimalDTO animalDTO, HttpServletRequest request) {

        try {

            Usuario user = usuarioService.buscarUsuarioPorToken(request.getHeader("Authorization"));
            animalService.salvar(animalDTO.converterToAnimal(user),foto);

            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getClass());
        }
    }
}

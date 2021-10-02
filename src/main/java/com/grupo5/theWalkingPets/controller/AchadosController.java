package com.grupo5.theWalkingPets.controller;

import com.grupo5.theWalkingPets.dto.AchadosDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/achados")
public class AchadosController {


    //@GetMapping
    public ResponseEntity<?> listagem(){


        return ResponseEntity.ok("a");
    }

    //@GetMapping
    public ResponseEntity<?> criacao(@RequestBody AchadosDTO achadosDTO){


        return ResponseEntity.ok("a");
    }
}

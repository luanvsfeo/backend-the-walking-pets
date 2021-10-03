package com.grupo5.theWalkingPets.service;

import com.grupo5.theWalkingPets.dto.AchadosDTO;
import com.grupo5.theWalkingPets.entity.Achados;
import com.grupo5.theWalkingPets.repository.AchadosRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AchadosService {

    private final AchadosRepository achadosRepository;

    public AchadosService(AchadosRepository achadosRepository) {
        this.achadosRepository = achadosRepository;
    }

    public void salvar(Achados achados){
        achadosRepository.save(achados);
    }

    public List<AchadosDTO> buscarTodos(){
        return converterParaDTO(achadosRepository.findAll());
    }

    private List<AchadosDTO> converterParaDTO(List<Achados> achados){
        List<AchadosDTO> achadosDTOS =  new ArrayList<>();

        for(Achados achado :achados){
            achadosDTOS.add(achado.converterParaDTO());
        }

        return achadosDTOS;
    }
}

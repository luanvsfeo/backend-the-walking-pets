package com.grupo5.theWalkingPets.service;

import com.grupo5.theWalkingPets.dto.AchadosDTO;
import com.grupo5.theWalkingPets.entity.Achados;
import com.grupo5.theWalkingPets.repository.AchadosRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AchadosService {

    private final AchadosRepository achadosRepository;

    private final FotoService fotoService;

    public AchadosService(AchadosRepository achadosRepository, FotoService fotoService) {
        this.achadosRepository = achadosRepository;
        this.fotoService = fotoService;
    }

    public void salvar(Achados achados, MultipartFile foto){
        achados.setFoto(fotoService.salvar(foto));
        achadosRepository.save(achados);
    }

    public List<AchadosDTO> buscarTodos() throws SQLException {
        return converterParaDTO(achadosRepository.findAll());
    }

    private List<AchadosDTO> converterParaDTO(List<Achados> achados) throws SQLException {
        List<AchadosDTO> achadosDTOS =  new ArrayList<>();

        for(Achados achado :achados){
            achadosDTOS.add(achado.converterParaDTO());
        }

        return achadosDTOS;
    }
}

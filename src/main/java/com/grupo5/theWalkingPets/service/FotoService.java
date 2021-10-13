package com.grupo5.theWalkingPets.service;

import com.grupo5.theWalkingPets.entity.Foto;
import com.grupo5.theWalkingPets.repository.FotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class FotoService {

    private final FotoRepository fotoRepository;

    public FotoService(FotoRepository fotoRepository) {
        this.fotoRepository = fotoRepository;
    }

    public Foto salvar(MultipartFile file) {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Foto FileDB = null;
        try {
            FileDB = new Foto(fileName, file.getContentType(), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fotoRepository.save(FileDB);
    }

    public Foto buscarPorId(Long id) {
        return fotoRepository.findById(id).get();
    }

    public Stream<Foto> buscarTodos() {
        return fotoRepository.findAll().stream();
    }
}

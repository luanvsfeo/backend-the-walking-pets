package com.grupo5.theWalkingPets.repository;

import com.grupo5.theWalkingPets.entity.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto,Long> {
}

package com.grupo5.theWalkingPets.repository;

import com.grupo5.theWalkingPets.entity.Achados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchadosRepository extends JpaRepository<Achados,Long> {

    List<Achados> findAllByCidade(String cidade);
}

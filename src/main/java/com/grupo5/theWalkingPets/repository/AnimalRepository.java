package com.grupo5.theWalkingPets.repository;

import com.grupo5.theWalkingPets.entity.Animal;
import com.grupo5.theWalkingPets.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long>  {


    List<Animal> findAllByDoarTrue();

    List<Animal> findAllByPerdidoTrue();

    List<Animal> findAllByUsuario(Usuario usuario);
}

package com.grupo5.theWalkingPets.repository;

import com.grupo5.theWalkingPets.entity.Animal;
import com.grupo5.theWalkingPets.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long>  {


    @Query(nativeQuery = true,value = "select * from animal where doar = true and usuario_id <> :id")
    List<Animal> findAllByDoarTrueAndUsuarioId(@Param("id") long usuarioId);

    List<Animal> findAllByPerdidoTrue();

    List<Animal> findAllByUsuario(Usuario usuario);
}

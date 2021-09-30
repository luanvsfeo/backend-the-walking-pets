package com.grupo5.theWalkingPets.repository;

import com.grupo5.theWalkingPets.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long>  {
}

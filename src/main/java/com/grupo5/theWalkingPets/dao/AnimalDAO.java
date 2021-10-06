package com.grupo5.theWalkingPets.dao;

import com.grupo5.theWalkingPets.dao.filter.AnimalFilter;
import com.grupo5.theWalkingPets.entity.Animal;
import java.util.List;

public interface AnimalDAO {

    List<Animal> buscarPorFiltros(AnimalFilter animalFilter);
}

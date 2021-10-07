package com.grupo5.theWalkingPets.service;

import com.grupo5.theWalkingPets.dao.filter.AnimalFilter;
import com.grupo5.theWalkingPets.dto.AnimalDTO;
import com.grupo5.theWalkingPets.entity.Animal;
import com.grupo5.theWalkingPets.entity.Usuario;
import com.grupo5.theWalkingPets.enumx.Sexo;
import com.grupo5.theWalkingPets.repository.AnimalRepository;
import com.grupo5.theWalkingPets.repository.UsuarioRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    private final UsuarioRepository usuarioRepository;

    public AnimalService(AnimalRepository animalRepository, UsuarioRepository usuarioRepository) {
        this.animalRepository = animalRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void salvar(Animal animal) {
        animalRepository.save(animal);
    }

    public List<AnimalDTO> buscarPorFiltro(AnimalFilter animalFilter, Usuario usuario) {
        animalFilter.setUsuarioId(usuario.getId());
        return converterParaDTO(animalRepository.buscarPorFiltros(animalFilter));
    }

    public List<AnimalDTO> buscarPerdidos() { //provisorio

        return converterParaDTO(animalRepository.findAllByPerdidoTrue());
    }

    public List<AnimalDTO> buscarMeusAnimais(Usuario usuario) { // provisorio
        return converterParaDTO(animalRepository.findAllByUsuario(usuario));
    }

//    public List<AnimalDTO> teste() {
//        //TODO - FAZER FILTROS PARA BUSCA MAIS PERSONALIZADA
//        return converterParaDTO(animalRepository.findAll(CustomerSpecs.isLongTermCustomer()));
//    }


    private List<AnimalDTO> converterParaDTO(List<Animal> animals) {
        List<AnimalDTO> animalDTOS = new ArrayList<>();

        for (Animal animal : animals) {
            animal.setUsuario(usuarioRepository.findById(animal.getUsuario().getId()).orElse(null));
            animalDTOS.add(animal.converterParaDTO());
        }
        return animalDTOS;
    }

//    public class CustomerSpecs {
//        public static Specification<Animal> isLongTermCustomer() {
//            return new Specification<Animal>() {
//                public Predicate toPredicate(Root<Animal> root, CriteriaQuery<?> query,
//                                             CriteriaBuilder builder) {
//
//                    Predicate predicate = builder.equal(root.get(Animal.Atributos.SEXO), Sexo.valueOf("MASCULINO"));
//                    return builder.equal(root.get(Animal.Atributos.SEXO), Sexo.valueOf("MASCULINO"));
//                }
//            };
//        }
//    }

}

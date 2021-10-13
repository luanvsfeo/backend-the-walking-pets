package com.grupo5.theWalkingPets.service;

import com.grupo5.theWalkingPets.dao.filter.AnimalFilter;
import com.grupo5.theWalkingPets.dto.AnimalDTO;
import com.grupo5.theWalkingPets.entity.Animal;
import com.grupo5.theWalkingPets.entity.Usuario;
import com.grupo5.theWalkingPets.repository.AnimalRepository;
import com.grupo5.theWalkingPets.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    private final UsuarioRepository usuarioRepository;

    private final FotoService fotoService;

    public AnimalService(AnimalRepository animalRepository, UsuarioRepository usuarioRepository, FotoService fotoService) {
        this.animalRepository = animalRepository;
        this.usuarioRepository = usuarioRepository;
        this.fotoService = fotoService;
    }

    public void salvar(Animal animal){
        animalRepository.save(animal);
    }

    public void salvar(Animal animal, MultipartFile foto) {
        animal.setFoto(fotoService.salvar(foto));
        animalRepository.save(animal);
    }

    public List<AnimalDTO> buscarPorFiltroParaListagem(AnimalFilter animalFilter, Usuario usuario) {
        animalFilter.setUsuarioId(usuario.getId());
        animalFilter.setDoar(true);
        animalFilter.setPerdido(false);

        return buscarPorFiltro(animalFilter);
    }

    public List<AnimalDTO> buscarPerdidos(Usuario usuario) { //provisorio
        AnimalFilter animalFilter = new AnimalFilter();
        animalFilter.setPerdido(true);
        animalFilter.setUsuarioId(usuario.getId());

        return buscarPorFiltro(animalFilter);
    }

    public List<AnimalDTO> buscarMeusAnimais(Usuario usuario) { // provisorio
        return converterParaDTO(animalRepository.findAllByUsuario(usuario));
    }

    private List<AnimalDTO> buscarPorFiltro(AnimalFilter animalFilter){
        return converterParaDTO(animalRepository.buscarPorFiltros(animalFilter));
    }

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

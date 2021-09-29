package com.grupo5.theWalkingPets.repository;

import com.grupo5.theWalkingPets.entity.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao,Long> {

    Permissao findByNome (String nome);

}

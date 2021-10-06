package com.grupo5.theWalkingPets.dao.impl;

import com.grupo5.theWalkingPets.dao.AnimalDAO;
import com.grupo5.theWalkingPets.dao.filter.AnimalFilter;
import com.grupo5.theWalkingPets.dao.rowMapper.AnimalRowMapper;
import com.grupo5.theWalkingPets.entity.Animal;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AnimalDAOImpl implements AnimalDAO {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AnimalDAOImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Animal> buscarPorFiltros(AnimalFilter animalFilter) {

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        //inner join usuario on usuario.id = animal.usuario_id
        StringBuilder SQL = new StringBuilder(" select * from animal where doar = true and perdido = false ");

        if(animalFilter.getEspecie() != null){
            SQL.append(" and especie = :campoEspecie ");
            namedParameters.addValue("campoEspecie", animalFilter.getEspecie().name());
        }

        if(animalFilter.getAnilha() != null){
            SQL.append(" and anilha like CONCAT('%',:campoAnilha,'%') ");
            namedParameters.addValue("campoAnilha", animalFilter.getAnilha());
        }

        if(animalFilter.getNome() != null){
            SQL.append(" and nome like CONCAT('%',:campoNome,'%') ");
            namedParameters.addValue("campoNome", animalFilter.getNome());
        }

        if(animalFilter.getIdade() != null){
            SQL.append(" and idade = :campoIdade ");
            namedParameters.addValue("campoIdade", animalFilter.getIdade());
        }

        if(animalFilter.getPorte() != null){
            SQL.append(" and porte = :campoPorte ");
            namedParameters.addValue("campoPorte", animalFilter.getPorte().name());
        }

        if(animalFilter.getTemperamento() != null){
            SQL.append(" and temperamento = :campoTemperamento ");
            namedParameters.addValue("campoTemperamento", animalFilter.getTemperamento().name());
        }

        if(animalFilter.getUsuarioId() != null){
            SQL.append(" and usuario_id <> :campoUsuario ");
            namedParameters.addValue("campoUsuario", animalFilter.getUsuarioId());
        }

        return namedParameterJdbcTemplate.query(SQL.toString(), namedParameters, new AnimalRowMapper());
    }
}

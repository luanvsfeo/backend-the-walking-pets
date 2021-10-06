package com.grupo5.theWalkingPets.dao.rowMapper;

import com.grupo5.theWalkingPets.entity.Animal;
import com.grupo5.theWalkingPets.entity.Usuario;
import com.grupo5.theWalkingPets.enumx.Especie;
import com.grupo5.theWalkingPets.enumx.Porte;
import com.grupo5.theWalkingPets.enumx.Sexo;
import com.grupo5.theWalkingPets.enumx.Temperamento;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimalRowMapper implements RowMapper<Animal> {

    @Override
    public Animal mapRow(ResultSet resultSet, int i) throws SQLException {

        Animal animal =  new Animal();
        animal.setId(resultSet.getLong(Animal.Colunas.ID));
        animal.setPelagem(resultSet.getString(Animal.Colunas.PELAGEM));
        animal.setDoar(resultSet.getBoolean(Animal.Colunas.DOAR));
        animal.setPorte(Porte.valueOf(String.valueOf(resultSet.getObject(Animal.Colunas.PORTE))));
        animal.setPerdido(resultSet.getBoolean(Animal.Colunas.PERDIDO));
        animal.setUsuario(new Usuario(resultSet.getLong("usuario_id")));
        animal.setSexo(Sexo.valueOf(String.valueOf(resultSet.getString(Animal.Colunas.SEXO))));
        animal.setAnilha(resultSet.getString(Animal.Colunas.ANILHA));
        animal.setRaca(resultSet.getString(Animal.Colunas.RACA));
        animal.setTemperamento(Temperamento.valueOf(String.valueOf(resultSet.getString(Animal.Colunas.TEMPERAMENTO))));
        animal.setVacinado(resultSet.getBoolean(Animal.Colunas.VACINADO));
        animal.setNome(resultSet.getString(Animal.Colunas.NOME));
        animal.setIdade(resultSet.getString(Animal.Colunas.IDADE));
        animal.setEspecie(Especie.valueOf(String.valueOf(resultSet.getString(Animal.Colunas.ESPECIE))));
        animal.setCastrado(resultSet.getBoolean(Animal.Colunas.CASTRADO));
        //animal.setFoto();
        return animal;
    }
}

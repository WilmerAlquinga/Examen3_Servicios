package com.arquitectura.examen.colegio.dao;

import com.arquitectura.examen.colegio.model.Paralelo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ParaleloRepository extends MongoRepository<Paralelo, String> {

    List<Paralelo> findByNivel(Integer nivel);

    Optional<Paralelo> findByNivelAndCodigo(Integer nivel, String paralelo);
}

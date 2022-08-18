package com.arquitectura.examen.colegio.dao;


import com.arquitectura.examen.colegio.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

    Boolean existsByCedula(String cedula);

    List<Estudiante> findByNivel(Integer nivel);

    Optional<Estudiante> findByCedula(String cedula);
}

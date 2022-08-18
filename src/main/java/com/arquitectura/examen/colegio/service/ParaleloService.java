package com.arquitectura.examen.colegio.service;

import com.arquitectura.examen.colegio.dao.EstudianteRepository;
import com.arquitectura.examen.colegio.dao.ParaleloRepository;
import com.arquitectura.examen.colegio.exception.NotFoundException;
import com.arquitectura.examen.colegio.model.Estudiante;
import com.arquitectura.examen.colegio.model.Paralelo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ParaleloService {

    private final ParaleloRepository paraleloRepository;

    private final EstudianteRepository estudianteRepository;

    public Paralelo asignarEstudiante(Integer nivel, String cedula) {
        Optional<Estudiante> estudiante = estudianteRepository.findByCedula(cedula);
        if(!estudiante.isPresent()) {
            throw new NotFoundException("El estudinate no existe");
        }

        List<Paralelo> paralelos =  paraleloRepository.findByNivel(nivel);
        if (paralelos.isEmpty()) {
            throw new NotFoundException("No existen paralelos en este nivel");
        }

        Integer random = new Random().nextInt(3) + 1;

        Paralelo paralelo = paralelos.get(random);
        paralelo.getEstudiantes().add(estudiante.get());

        return paraleloRepository.save(paralelo);
    }
}

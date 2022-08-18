package com.arquitectura.examen.colegio.service;

import com.arquitectura.examen.colegio.dao.EstudianteRepository;
import com.arquitectura.examen.colegio.dao.ParaleloRepository;
import com.arquitectura.examen.colegio.exception.CreateException;
import com.arquitectura.examen.colegio.exception.NotFoundException;
import com.arquitectura.examen.colegio.model.Estudiante;
import com.arquitectura.examen.colegio.model.Paralelo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    private final ParaleloRepository paraleloRepository;

    public Boolean validarRepetido(String cedula) {
        return estudianteRepository.existsByCedula(cedula);
    }

    public List<Estudiante> buscarPorNivel(Integer nivel) {
        List<Estudiante> estudiantes = estudianteRepository.findByNivel(nivel);
        return estudiantes;
    }

    public void crearEstudiante(Estudiante estudiante) {
        Boolean existe = this.validarRepetido(estudiante.getCedula());
        if (existe) {
            throw new CreateException("El estudiante ya existe");
        }
        estudianteRepository.save(estudiante);
    }

    public List<Estudiante> buscarPorNivelParalelo(Integer nivel, String paralelo) {
        Optional<Paralelo> paraleloOpt = paraleloRepository.findByNivelAndCodigo(nivel, paralelo);
        if (!paraleloOpt.isPresent()) {
            throw new NotFoundException("No existen estudiantes para el nivel y paralelo especificados");
        }
        List<Estudiante> estudiantes = paraleloOpt.get().getEstudiantes();
        return estudiantes;
    }
}

package com.arquitectura.examen.colegio.resource;

import com.arquitectura.examen.colegio.model.Estudiante;
import com.arquitectura.examen.colegio.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
@RequiredArgsConstructor
public class EstudianteResource {

    private final EstudianteService estudianteService;

    @GetMapping("/{nivel}")
    public ResponseEntity<List<Estudiante>> buscarPorNivel(@PathVariable Integer nivel) {
        List<Estudiante> estudiantes = estudianteService.buscarPorNivel(nivel);
        return ResponseEntity.ok(estudiantes);
    }

    @PostMapping
    public ResponseEntity crearEstudiante(@RequestBody Estudiante estudiante) {
        estudianteService.crearEstudiante(estudiante);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{nivel}/{paralelo}")
    public ResponseEntity<List<Estudiante>> buscarPorNivelYParalelo(@PathVariable Integer nivel, @PathVariable String paralelo) {
        List<Estudiante> estudiantes = estudianteService.buscarPorNivelParalelo(nivel, paralelo);
        return ResponseEntity.ok(estudiantes);
    }
}

package com.arquitectura.examen.colegio.resource;

import com.arquitectura.examen.colegio.model.Estudiante;
import com.arquitectura.examen.colegio.model.Paralelo;
import com.arquitectura.examen.colegio.service.ParaleloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class ParaleloResource {

    private final ParaleloService paraleloService;

    @PostMapping
    public ResponseEntity<Paralelo> asignarParalelo(@RequestBody Estudiante estudiante) {
        Paralelo paralelo = paraleloService.asignarEstudiante(estudiante.getNivel(), estudiante.getCedula());
        return ResponseEntity.ok(paralelo);
    }
}

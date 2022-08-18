package com.arquitectura.examen.colegio.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "estudiante")
@TypeAlias("estudiante")
public class Estudiante {

    @Id
    private String id;

    @Indexed(name = "idx_estudiante_nivel")
    private Integer nivel;

    @Indexed(name = "idxu_estudiante_cedula", unique = true)
    private String cedula;

    private String apellidos;

    private String nombres;
}

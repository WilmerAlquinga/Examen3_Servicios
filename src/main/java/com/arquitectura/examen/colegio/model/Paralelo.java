package com.arquitectura.examen.colegio.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "paralelo")
@TypeAlias("paralelo")
public class Paralelo {

    @Id
    private String id;

    private String codigo;

    private Integer nivel;

    private List<Estudiante> estudiantes;
}

package com.german.edsystem.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "calificacion")
@Data
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "id_alumno", nullable = false, referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Alumno alumno;
    @JoinColumn(name = "id_docente", nullable = false,referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Docente docente;
    @JoinColumn(name = "id_asignatura", nullable = false, referencedColumnName = "id_asignatura")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asignatura asignatura;
    @JoinColumn(name = "id_periodo", nullable = false, referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PeriodoAcademico periodoAcademico;
    @Column(precision = 3, nullable = true)
    private Double nota1;
    @Column(precision = 3, nullable = true)
    private Double nota2;
    @Column(precision = 3, nullable = true)
    private Double nota3;
    @Column(precision = 3, nullable = true)
    private Double nota4;
    @Column(precision = 3, nullable = true)
    private Double notaDefinitiva;

}

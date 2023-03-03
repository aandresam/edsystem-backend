package com.german.edsystem.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "calificacion_anual")
public class CalificacionAnual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno", nullable = false, referencedColumnName = "id")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_asignatura", nullable = false, referencedColumnName = "id_asignatura")
    private Asignatura asignatura;
    @Column(precision = 3, nullable = true)
    private Double periodo1;
    @Column(precision = 3, nullable = true)
    private Double periodo2;
    @Column(precision = 3, nullable = true)
    private Double periodo3;
    @Column(precision = 3, nullable = true)
    private Double periodo4;

    @Column(name = "nota_final_anual")
    private Double notaFinalAnual;
}

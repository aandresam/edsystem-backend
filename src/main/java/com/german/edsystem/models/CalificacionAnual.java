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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_calificacion", nullable = false, referencedColumnName = "id")
    private Calificacion calificacion;

    @Column(name = "nota_final_anual")
    private Double notaFinalAnual;
}

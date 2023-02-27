package com.german.edsystem.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "asignacion_curso")
public class AsignacionCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion")
    private Integer idAsignacion;
    @JoinColumn(name = "id_alumno", referencedColumnName = "id")
    @ManyToOne
    private Alumno alumno;
    @JoinColumn(name = "id_docente", referencedColumnName = "id")
    @ManyToOne
    private Docente docente;
    @JoinColumn(name = "id_horario", referencedColumnName = "id_horario")
    @ManyToOne
    private Horario horario;
}

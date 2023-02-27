package com.german.edsystem.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Integer idHorario;
    private String descripcion;
}

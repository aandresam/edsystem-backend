package com.german.edsystem.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Integer idAsignatura;
    private String nombre;
}

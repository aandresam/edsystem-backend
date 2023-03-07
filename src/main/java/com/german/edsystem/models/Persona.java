package com.german.edsystem.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Contacto contacto;
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id_domicilio", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate fechaNacimiento;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @PrePersist
    public void prePersist() {
        fechaRegistro = LocalDateTime.now();
    }

}
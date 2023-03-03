package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepositoryJpa extends JpaRepository<Calificacion, Integer> {
}

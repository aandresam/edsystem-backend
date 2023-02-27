package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.AsignacionAsignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AsignacionAsignaturaRepositoryJpa extends JpaRepository<AsignacionAsignatura, Integer> {
}

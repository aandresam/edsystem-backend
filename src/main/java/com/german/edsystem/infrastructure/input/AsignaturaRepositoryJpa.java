package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AsignaturaRepositoryJpa extends JpaRepository<Asignatura, Integer> {
}

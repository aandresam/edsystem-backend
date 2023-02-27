package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.AsignacionCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AsignacionCursoRepositoryJpa extends JpaRepository<AsignacionCurso, Integer> {
}

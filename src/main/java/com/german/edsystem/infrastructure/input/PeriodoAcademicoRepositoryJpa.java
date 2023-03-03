package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.PeriodoAcademico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoAcademicoRepositoryJpa extends JpaRepository<PeriodoAcademico, Integer> {
}

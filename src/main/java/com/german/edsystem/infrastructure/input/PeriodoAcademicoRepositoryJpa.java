package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.PeriodoAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PeriodoAcademicoRepositoryJpa extends JpaRepository<PeriodoAcademico, Integer> {

    @Query("SELECT p FROM PeriodoAcademico p WHERE p.isActive = true")
    PeriodoAcademico findByIsActive();
}

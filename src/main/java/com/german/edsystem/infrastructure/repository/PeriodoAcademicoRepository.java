package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.PeriodoAcademico;

import java.util.Optional;

public interface PeriodoAcademicoRepository {
    Iterable<PeriodoAcademico> getPeriodos();
    Optional<PeriodoAcademico> getPeriodoById(Integer id);
    PeriodoAcademico savePeriodo(PeriodoAcademico periodoAcademico);
    void deletePeriodoById(Integer id);
}

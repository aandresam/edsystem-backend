package com.german.edsystem.service;

import com.german.edsystem.models.PeriodoAcademico;

import java.util.Optional;

public interface IPeriodoAcademicoService {
    Iterable<PeriodoAcademico> getPeriodos();
    Optional<PeriodoAcademico> getPeriodoById(Integer id);
    PeriodoAcademico savePeriodo(PeriodoAcademico periodoAcademico);
    void deletePeriodoById(Integer id);
}

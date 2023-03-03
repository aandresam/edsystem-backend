package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.PeriodoAcademicoRepository;
import com.german.edsystem.models.PeriodoAcademico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PeriodoAcademicoService implements IPeriodoAcademicoService {
    private final PeriodoAcademicoRepository periodoAcademicoRepository;
    @Override
    public Iterable<PeriodoAcademico> getPeriodos() {
        return this.periodoAcademicoRepository.getPeriodos();
    }

    @Override
    public Optional<PeriodoAcademico> getPeriodoById(Integer id) {
        return this.periodoAcademicoRepository.getPeriodoById(id);
    }

    @Override
    public PeriodoAcademico savePeriodo(PeriodoAcademico periodoAcademico) {
        return this.periodoAcademicoRepository.savePeriodo(periodoAcademico);
    }

    @Override
    public void deletePeriodoById(Integer id) {
        this.periodoAcademicoRepository.deletePeriodoById(id);
    }
}

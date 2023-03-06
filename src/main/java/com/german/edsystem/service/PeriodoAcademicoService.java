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
    public PeriodoAcademico createPeriodo(PeriodoAcademico periodoAcademico) {
        return this.periodoAcademicoRepository.savePeriodo(periodoAcademico);
    }
    @Override
    public PeriodoAcademico updatePeriodo(PeriodoAcademico periodoAcademico) {
        Optional<PeriodoAcademico> existingPeriodo = this.periodoAcademicoRepository
                                                                .getPeriodoById(periodoAcademico.getId());
        if (existingPeriodo.isEmpty()) {
            return null;
        }
        existingPeriodo.get().setNombre(periodoAcademico.getNombre());
        existingPeriodo.get().setFechaInicio(periodoAcademico.getFechaInicio());
        existingPeriodo.get().setFechaFin(periodoAcademico.getFechaFin());
        existingPeriodo.get().setActive(periodoAcademico.isActive());
        return this.periodoAcademicoRepository.savePeriodo(existingPeriodo.get());
    }
    @Override
    public void deletePeriodoById(Integer id) {
        this.periodoAcademicoRepository.deletePeriodoById(id);
    }
}

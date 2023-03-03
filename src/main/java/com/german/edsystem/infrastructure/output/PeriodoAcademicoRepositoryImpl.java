package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.PeriodoAcademicoRepositoryJpa;
import com.german.edsystem.infrastructure.repository.PeriodoAcademicoRepository;
import com.german.edsystem.models.PeriodoAcademico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class PeriodoAcademicoRepositoryImpl implements PeriodoAcademicoRepository {
    private final PeriodoAcademicoRepositoryJpa periodoAcademicoRepositoryJpa;
    @Override
    public Iterable<PeriodoAcademico> getPeriodos() {
        return this.periodoAcademicoRepositoryJpa.findAll();
    }

    @Override
    public Optional<PeriodoAcademico> getPeriodoById(Integer id) {
        return this.periodoAcademicoRepositoryJpa.findById(id);
    }

    @Override
    public PeriodoAcademico savePeriodo(PeriodoAcademico periodoAcademico) {
        return this.periodoAcademicoRepositoryJpa.save(periodoAcademico);
    }

    @Override
    public void deletePeriodoById(Integer id) {
        this.periodoAcademicoRepositoryJpa.deleteById(id);
    }
}

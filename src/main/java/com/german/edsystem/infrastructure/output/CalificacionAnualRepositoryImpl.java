package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.CalificacionAnualRepositoryJpa;
import com.german.edsystem.infrastructure.repository.CalificacionAnualRepository;
import com.german.edsystem.models.CalificacionAnual;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CalificacionAnualRepositoryImpl implements CalificacionAnualRepository {
    private final CalificacionAnualRepositoryJpa calificacionAnualRepositoryJpa;

    @Override
    public Iterable<CalificacionAnual> getCalificaciones() {
        return this.calificacionAnualRepositoryJpa.findAll();
    }

    @Override
    public Optional<CalificacionAnual> getCalificacionById(Integer id) {
        return this.calificacionAnualRepositoryJpa.findById(id);
    }

    @Override
    public CalificacionAnual saveCalificacion(CalificacionAnual calificacion) {
        return this.calificacionAnualRepositoryJpa.save(calificacion);
    }

    @Override
    public void deleteCalificacionById(Integer id) {
        this.calificacionAnualRepositoryJpa.deleteById(id);
    }
}

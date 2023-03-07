package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.CalificacionRepositoryJpa;
import com.german.edsystem.infrastructure.repository.CalificacionRepository;
import com.german.edsystem.models.Calificacion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CalificacionRepositoryImpl implements CalificacionRepository {
    private final CalificacionRepositoryJpa calificacionRepositoryJpa;
    @Override
    public Iterable<Calificacion> getCalificaciones() {
        return this.calificacionRepositoryJpa.findAll();
    }

    @Override
    public Optional<Calificacion> getCalificacionById(Integer id) {
        return this.calificacionRepositoryJpa.findById(id);
    }

    @Override
    public Calificacion saveCalificacion(Calificacion calificacion) {
        return this.calificacionRepositoryJpa.save(calificacion);
    }

    @Override
    public void deleteCalificacionById(Integer id) {
        this.calificacionRepositoryJpa.deleteById(id);
    }
}

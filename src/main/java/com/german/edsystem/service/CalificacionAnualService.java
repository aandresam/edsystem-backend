package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.CalificacionAnualRepository;
import com.german.edsystem.models.CalificacionAnual;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CalificacionAnualService implements ICalificacionAnualService {
    private final CalificacionAnualRepository calificacionAnualRepository;
    @Override
    public Iterable<CalificacionAnual> getCalificaciones() {
        return this.calificacionAnualRepository.getCalificaciones();
    }

    @Override
    public Optional<CalificacionAnual> getCalificacionById(Integer id) {
        return this.calificacionAnualRepository.getCalificacionById(id);
    }

    @Override
    public CalificacionAnual saveCalificacion(CalificacionAnual calificacion) {
        return this.calificacionAnualRepository.saveCalificacion(calificacion);
    }

    @Override
    public void deleteCalificacionById(Integer id) {
        this.calificacionAnualRepository.deleteCalificacionById(id);
    }

    @Override
    public CalificacionAnual promediarCalificacion(CalificacionAnual calificacionAnual) {
        return null;
    }
}

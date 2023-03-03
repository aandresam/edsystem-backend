package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.CalificacionAnual;

import java.util.Optional;

public interface CalificacionAnualRepository {
    Iterable<CalificacionAnual> getCalificaciones();
    Optional<CalificacionAnual> getCalificacionById(Integer id);
    CalificacionAnual saveCalificacion(CalificacionAnual calificacion);
    void deleteCalificacionById(Integer id);
}

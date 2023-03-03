package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Calificacion;

import java.util.Optional;

public interface CalificacionRepository {
    Iterable<Calificacion> getCalificaciones();
    Optional<Calificacion> getCalificacionById(Integer id);
    Calificacion saveCalificacion(Calificacion calificacion);
    void deleteCalificacionById(Integer id);
}

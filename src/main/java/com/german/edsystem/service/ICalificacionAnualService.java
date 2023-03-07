package com.german.edsystem.service;

import com.german.edsystem.models.CalificacionAnual;

import java.util.Optional;

public interface ICalificacionAnualService {
    Iterable<CalificacionAnual> getCalificaciones();
    Optional<CalificacionAnual> getCalificacionById(Integer id);
    CalificacionAnual createCalificacion(CalificacionAnual calificacion);
    CalificacionAnual updateCalificacion(CalificacionAnual calificacion);
    void deleteCalificacionById(Integer id);
}

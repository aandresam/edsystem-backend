package com.german.edsystem.service;

import com.german.edsystem.models.Calificacion;

import java.util.Optional;

public interface ICalificacionService {
    Iterable<Calificacion> getCalificaciones();
    Optional<Calificacion> getCalificacionById(Integer id);
    Calificacion createCalificacion(Calificacion calificacion);
    Calificacion updateCalificacion(Calificacion calificacion);
    void deleteCalificacionById(Integer id);
}

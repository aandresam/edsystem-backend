package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.AsignacionAsignatura;

import java.util.Optional;

public interface AsignacionAsignaturaRepository {
    Optional<AsignacionAsignatura> getAsignacionById(Integer id);
    Iterable<AsignacionAsignatura> getAsignaciones();
    AsignacionAsignatura saveAsignacion(AsignacionAsignatura asignacion);
    void deleteAsignacionById(Integer id);
}

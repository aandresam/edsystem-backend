package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.AsignacionAsignatura;

import java.util.List;

public interface AsignacionAsignaturaRepository {
    AsignacionAsignatura getAsignacionById(Integer id);
    List<AsignacionAsignatura> getAsignaciones();
    AsignacionAsignatura saveAsignacion(AsignacionAsignatura asignacion);
    void deleteAsignacionById(Integer id);
}

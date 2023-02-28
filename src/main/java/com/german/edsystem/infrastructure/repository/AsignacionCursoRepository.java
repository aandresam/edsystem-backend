package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.AsignacionCurso;

import java.util.Optional;

public interface AsignacionCursoRepository {
    Optional<AsignacionCurso> getAsignacionById(Integer id);
    Iterable<AsignacionCurso> getAsignaciones();
    AsignacionCurso saveAsignacion(AsignacionCurso curso);
    void deleteAsignacionById(Integer id);
}

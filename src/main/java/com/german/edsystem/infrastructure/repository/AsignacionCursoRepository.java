package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.AsignacionCurso;

import java.util.List;

public interface AsignacionCursoRepository {
    AsignacionCurso getAsignacionById(Integer id);
    List<AsignacionCurso> getAsignaciones();
    AsignacionCurso saveAsignacion(AsignacionCurso curso);
    void deleteAsignacionById(Integer id);
}

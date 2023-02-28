package com.german.edsystem.service;

import com.german.edsystem.models.AsignacionCurso;

import java.util.Optional;

public interface IAsignacionCursoService {

    Iterable<AsignacionCurso> getAsignaciones();

    Optional<AsignacionCurso> getAsignacion(Integer id);

    AsignacionCurso saveAsignacion(AsignacionCurso asignacion);

    void deleteAsignacionById(Integer id);
}

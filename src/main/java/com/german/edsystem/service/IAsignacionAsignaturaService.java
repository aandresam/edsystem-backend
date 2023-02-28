package com.german.edsystem.service;

import com.german.edsystem.models.AsignacionAsignatura;

import java.util.Optional;

public interface IAsignacionAsignaturaService {

    Iterable<AsignacionAsignatura> getAsignaciones();

    Optional<AsignacionAsignatura> getAsignacionById(Integer id);

    AsignacionAsignatura saveAsignacion(AsignacionAsignatura asignacionAsignatura);

    void deleteAsignacionById(Integer asignacionAsignatura);
}

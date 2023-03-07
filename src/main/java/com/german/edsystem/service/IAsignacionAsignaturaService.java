package com.german.edsystem.service;

import com.german.edsystem.models.AsignacionAsignatura;

import java.util.Optional;

public interface IAsignacionAsignaturaService {

    Iterable<AsignacionAsignatura> getAsignaciones();

    Optional<AsignacionAsignatura> getAsignacionById(Integer id);

    AsignacionAsignatura createAsignacion(AsignacionAsignatura asignacionAsignatura);
    AsignacionAsignatura updateAsignacion(AsignacionAsignatura asignacionAsignatura);

    void deleteAsignacionById(Integer asignacionAsignatura);
}

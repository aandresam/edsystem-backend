package com.german.edsystem.service;

import com.german.edsystem.models.Asignatura;

import java.util.Optional;

public interface IAsignaturaService {
    Iterable<Asignatura> getAsignaturas();

    Optional<Asignatura> getAsignatura(Integer id);

    Asignatura createAsignatura(Asignatura asignatura);
    Asignatura updateAsignatura(Asignatura asignatura);

    void deleteAsignaturaById(Integer id);
}

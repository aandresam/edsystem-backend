package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Asignatura;

import java.util.Optional;

public interface AsignaturaRepository {
    Optional<Asignatura> getAsignaturaById(Integer id);
    Iterable<Asignatura> getAsignaturas();
    Asignatura saveAsignatura(Asignatura asignatura);
    void deleteAsignaturaById(Integer id);
}

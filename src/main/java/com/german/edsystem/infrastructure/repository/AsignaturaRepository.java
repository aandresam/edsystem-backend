package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Asignatura;

import java.util.List;

public interface AsignaturaRepository {
    Asignatura getAsignaturaById(Integer id);
    List<Asignatura> getAsignaturas();
    Asignatura saveAsignatura(Asignatura asignatura);
    void deleteAsignaturaById(Integer id);
}

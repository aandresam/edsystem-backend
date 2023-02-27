package com.german.edsystem.service;

import com.german.edsystem.models.Asignatura;

import java.util.List;

public interface IAsignaturaService {
    public List<Asignatura> getAsignaturas();

    public Asignatura getAsignatura(Integer id);

    public Asignatura saveAsignatura(Asignatura asignatura);

    public void deleteAsignaturaById(Integer id);
}

package com.german.edsystem.service;

import com.german.edsystem.models.AsignacionAsignatura;

import java.util.List;

public interface IAsignacionAsignaturaService {

    public List<AsignacionAsignatura> getAsignaciones();

    public AsignacionAsignatura getAsignacionById(Integer id);

    public AsignacionAsignatura saveAsignacion(AsignacionAsignatura asignacionAsignatura);

    public void deleteAsignacionById(Integer asignacionAsignatura);
}

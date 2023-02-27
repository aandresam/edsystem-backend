package com.german.edsystem.service;

import com.german.edsystem.models.AsignacionCurso;

import java.util.List;

public interface IAsignacionCursoService {

    public List<AsignacionCurso> getAsignaciones();

    public AsignacionCurso getAsignacion(Integer id);

    public AsignacionCurso saveAsignacion(AsignacionCurso asignacion);

    public void deleteAsignacionById(Integer id);
}

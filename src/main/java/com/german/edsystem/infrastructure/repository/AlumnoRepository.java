package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Alumno;

import java.util.List;

public interface AlumnoRepository {
    Alumno getAlumnoById(Integer id);
    List<Alumno> getAlumnos();
    Alumno saveAlumno(Alumno alumno);
    void deleteAlumnoById(Integer id);
}

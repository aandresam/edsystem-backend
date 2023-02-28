package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Alumno;

import java.util.*;

public interface AlumnoRepository {
    Optional<Alumno> getAlumnoById(Integer id);
    Iterable<Alumno> getAlumnos();
    Alumno saveAlumno(Alumno alumno);
    void deleteAlumnoById(Integer id);
}

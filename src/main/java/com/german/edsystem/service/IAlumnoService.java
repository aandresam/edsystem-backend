package com.german.edsystem.service;

import com.german.edsystem.models.Alumno;

import java.util.Optional;

public interface IAlumnoService {

    Iterable<Alumno> getAlumnos();

    Optional<Alumno> getAlumnoById(Integer id);

    Alumno saveAlumno(Alumno alumno);

    void deleteAlumnoById(Integer id);
}

package com.german.edsystem.service;

import com.german.edsystem.models.Alumno;

import java.util.List;

public interface IAlumnoService {

    public List<Alumno> getAlumnos();

    public Alumno getAlumnoById(Integer id);

    public Alumno saveAlumno(Alumno alumno);

    public void deleteAlumnoById(Integer id);
}

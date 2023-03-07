package com.german.edsystem.service;

import com.german.edsystem.models.Curso;

import java.util.Optional;

public interface ICursoService {
    Iterable<Curso> getCursos();

    Optional<Curso> getCurso(Integer id);

    Curso createCurso(Curso curso);
    Curso updateCurso(Curso curso);

    void deleteCursoById(Integer id);
}

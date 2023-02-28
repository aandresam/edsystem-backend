package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Curso;

import java.util.Optional;

public interface CursoRepository {
    Optional<Curso> getCursoById(Integer id);
    Iterable<Curso> getCursos();
    Curso saveCurso(Curso curso);
    void deleteCursoById(Integer id);
}

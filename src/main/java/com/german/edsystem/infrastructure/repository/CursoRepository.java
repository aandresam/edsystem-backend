package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Curso;

import java.util.List;

public interface CursoRepository {
    Curso getCursoById(Integer id);
    List<Curso> getCursos();
    Curso saveCurso(Curso curso);
    void deleteCursoById(Integer id);
}

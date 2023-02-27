package com.german.edsystem.service;

import com.german.edsystem.models.Curso;

import java.util.List;

public interface ICursoService {
    public List<Curso> getCursos();

    public Curso getCurso(Integer id);

    public Curso saveCurso(Curso curso);

    public void deleteCursoById(Integer id);
}

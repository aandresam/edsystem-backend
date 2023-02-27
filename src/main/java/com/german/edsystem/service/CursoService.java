package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.CursoRepository;
import com.german.edsystem.models.Curso;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CursoService implements ICursoService {

    private final CursoRepository cursoRepository;

    @Override
    public List<Curso> getCursos() {
        return this.cursoRepository.getCursos();
    }

    @Override
    public Curso getCurso(Integer id) {
        return this.cursoRepository.getCursoById(id);
    }

    @Override
    public Curso saveCurso(Curso curso) {
        return this.cursoRepository.saveCurso(curso);
    }

    @Override
    public void deleteCursoById(Integer id) {
        this.cursoRepository.deleteCursoById(id);
    }
}

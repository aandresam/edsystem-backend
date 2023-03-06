package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.CursoRepository;
import com.german.edsystem.models.Curso;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CursoService implements ICursoService {

    private final CursoRepository cursoRepository;

    @Override
    public Iterable<Curso> getCursos() {
        return this.cursoRepository.getCursos();
    }

    @Override
    public Optional<Curso> getCurso(Integer id) {
        return this.cursoRepository.getCursoById(id);
    }

    @Override
    public Curso createCurso(Curso curso) {
        return this.cursoRepository.saveCurso(curso);
    }
    @Override
    public Curso updateCurso(Curso curso) {
        Optional<Curso> existingCurso = this.cursoRepository.getCursoById(curso.getIdCurso());
        if (existingCurso.isEmpty()) {
            return null;
        }
        existingCurso.get().setNombre(curso.getNombre());
        existingCurso.get().setCapacidad(curso.getCapacidad());
        return this.cursoRepository.saveCurso(existingCurso.get());
    }

    @Override
    public void deleteCursoById(Integer id) {
        this.cursoRepository.deleteCursoById(id);
    }
}

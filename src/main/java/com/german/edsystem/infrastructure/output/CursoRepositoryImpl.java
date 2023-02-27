package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.CursoRepositoryJpa;
import com.german.edsystem.infrastructure.repository.CursoRepository;
import com.german.edsystem.models.Curso;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CursoRepositoryImpl implements CursoRepository {
    private final CursoRepositoryJpa cursoRepositoryJpa;

    @Override
    public List<Curso> getCursos() {
        return this.cursoRepositoryJpa.findAll();
    }

    @Override
    public Curso getCursoById(Integer id) {
        return this.cursoRepositoryJpa.findById(id).orElse(null);
    }

    @Override
    public Curso saveCurso(Curso curso) {
        return this.cursoRepositoryJpa.save(curso);
    }

    @Override
    public void deleteCursoById(Integer id) {
        this.cursoRepositoryJpa.deleteById(id);
    }
}

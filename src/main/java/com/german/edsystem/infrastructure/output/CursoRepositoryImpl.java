package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.CursoRepositoryJpa;
import com.german.edsystem.infrastructure.repository.CursoRepository;
import com.german.edsystem.models.Curso;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CursoRepositoryImpl implements CursoRepository {
    private final CursoRepositoryJpa cursoRepositoryJpa;

    @Override
    public Iterable<Curso> getCursos() {
        return this.cursoRepositoryJpa.findAll();
    }

    @Override
    public Optional<Curso> getCursoById(Integer id) {
        Curso curso = this.cursoRepositoryJpa.findById(id).orElse(null);
        return Optional.ofNullable(curso);
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

package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.DocenteRepositoryJpa;
import com.german.edsystem.infrastructure.repository.DocenteRepository;
import com.german.edsystem.models.Docente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class DocenteRepositoryImpl implements DocenteRepository {
    private final DocenteRepositoryJpa docenteRepositoryJpa;

    @Override
    public Iterable<Docente> getDocentes() {
        return this.docenteRepositoryJpa.findAll();
    }

    @Override
    public Optional<Docente> getDocenteById(Integer id) {
        Docente docente = this.docenteRepositoryJpa.findById(id).orElse(null);
        return Optional.ofNullable(docente);
    }

    @Override
    public Docente saveDocente(Docente asignacion) {
        return this.docenteRepositoryJpa.save(asignacion);
    }

    @Override
    public void deleteDocenteById(Integer id) {
        this.docenteRepositoryJpa.deleteById(id);
    }
}

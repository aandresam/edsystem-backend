package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.DocenteRepositoryJpa;
import com.german.edsystem.infrastructure.repository.DocenteRepository;
import com.german.edsystem.models.Docente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class DocenteRepositoryImpl implements DocenteRepository {
    private final DocenteRepositoryJpa docenteRepositoryJpa;

    @Override
    public List<Docente> getDocentes() {
        return this.docenteRepositoryJpa.findAll();
    }

    @Override
    public Docente getDocenteById(Integer id) {
        return this.docenteRepositoryJpa.findById(id).orElse(null);
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

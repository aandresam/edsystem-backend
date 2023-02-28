package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.AsignaturaRepositoryJpa;
import com.german.edsystem.infrastructure.repository.AsignaturaRepository;
import com.german.edsystem.models.Asignatura;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class AsignaturaRepositoryImpl implements AsignaturaRepository {
    private final AsignaturaRepositoryJpa asignaturaRepositoryJpa;
    @Override
    public Iterable<Asignatura> getAsignaturas() {
        return this.asignaturaRepositoryJpa.findAll();
    }

    @Override
    public Optional<Asignatura> getAsignaturaById(Integer id) {
        Asignatura asignatura = this.asignaturaRepositoryJpa.findById(id).orElse(null);
        return Optional.ofNullable(asignatura);
    }

    @Override
    public Asignatura saveAsignatura(Asignatura asignatura) {
        return this.asignaturaRepositoryJpa.save(asignatura);
    }

    @Override
    public void deleteAsignaturaById(Integer id) {
        this.asignaturaRepositoryJpa.deleteById(id);
    }
}

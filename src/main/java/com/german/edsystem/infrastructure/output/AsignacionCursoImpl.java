package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.AsignacionCursoRepositoryJpa;
import com.german.edsystem.infrastructure.repository.AsignacionCursoRepository;
import com.german.edsystem.models.AsignacionAsignatura;
import com.german.edsystem.models.AsignacionCurso;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class AsignacionCursoImpl implements AsignacionCursoRepository {

    private final AsignacionCursoRepositoryJpa asignacionCursoRepositoryJpa;
    @Override
    public Iterable<AsignacionCurso> getAsignaciones() {
        return this.asignacionCursoRepositoryJpa.findAll();
    }
    @Override
    public Optional<AsignacionCurso> getAsignacionById(Integer id) {
        AsignacionCurso asignacion =  this.asignacionCursoRepositoryJpa.findById(id).orElse(null);
        return Optional.ofNullable(asignacion);
    }
    @Override
    public AsignacionCurso saveAsignacion(AsignacionCurso asignacion) {
        return this.asignacionCursoRepositoryJpa.save(asignacion);
    }
    @Override
    public void deleteAsignacionById(Integer id) {
        this.asignacionCursoRepositoryJpa.deleteById(id);
    }
}

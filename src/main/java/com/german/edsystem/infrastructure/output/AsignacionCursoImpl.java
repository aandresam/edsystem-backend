package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.AsignacionCursoRepositoryJpa;
import com.german.edsystem.infrastructure.repository.AsignacionCursoRepository;
import com.german.edsystem.models.AsignacionCurso;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AsignacionCursoImpl implements AsignacionCursoRepository {

    private final AsignacionCursoRepositoryJpa asignacionCursoRepositoryJpa;
    @Override
    public List<AsignacionCurso> getAsignaciones() {
        return this.asignacionCursoRepositoryJpa.findAll();
    }
    @Override
    public AsignacionCurso getAsignacionById(Integer id) {
        return this.asignacionCursoRepositoryJpa.findById(id).orElse(null);
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

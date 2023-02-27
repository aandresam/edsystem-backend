package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.AsignacionAsignaturaRepositoryJpa;
import com.german.edsystem.infrastructure.repository.AsignacionAsignaturaRepository;
import com.german.edsystem.models.AsignacionAsignatura;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AsignacionAsignaturaImpl implements AsignacionAsignaturaRepository {
    private final AsignacionAsignaturaRepositoryJpa asignacionAsignaturaRepositoryJpa;
    @Override
    public List<AsignacionAsignatura> getAsignaciones() {
        return this.asignacionAsignaturaRepositoryJpa.findAll();
    }

    @Override
    public AsignacionAsignatura getAsignacionById(Integer id) {
        return this.asignacionAsignaturaRepositoryJpa.findById(id).orElse(null);
    }

    @Override
    public AsignacionAsignatura saveAsignacion(AsignacionAsignatura asignacionAsignatura) {
        return this.asignacionAsignaturaRepositoryJpa.save(asignacionAsignatura);
    }

    @Override
    public void deleteAsignacionById(Integer id) {
        this.asignacionAsignaturaRepositoryJpa.deleteById(id);
    }
}

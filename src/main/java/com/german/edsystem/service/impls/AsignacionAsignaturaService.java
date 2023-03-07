package com.german.edsystem.service.impls;

import com.german.edsystem.infrastructure.repository.AsignacionAsignaturaRepository;
import com.german.edsystem.models.AsignacionAsignatura;
import com.german.edsystem.service.IAsignacionAsignaturaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AsignacionAsignaturaService implements IAsignacionAsignaturaService {

    private final AsignacionAsignaturaRepository asignacionAsignaturaRepository;
    @Override
    public Iterable<AsignacionAsignatura> getAsignaciones() {
        return this.asignacionAsignaturaRepository.getAsignaciones();
    }

    @Override
    public Optional<AsignacionAsignatura> getAsignacionById(Integer id) {
        return this.asignacionAsignaturaRepository.getAsignacionById(id);
    }

    @Override
    public AsignacionAsignatura createAsignacion(AsignacionAsignatura asignacion) {
        return this.asignacionAsignaturaRepository.saveAsignacion(asignacion);
    }
    @Override
    public AsignacionAsignatura updateAsignacion(AsignacionAsignatura asignacion) {
        Optional<AsignacionAsignatura> existingAsignacion = this.getAsignacionById(asignacion.getIdAsignacion());
        if (existingAsignacion.isEmpty()) {
            return null;
        }
        existingAsignacion.get().setDocente(asignacion.getDocente());
        existingAsignacion.get().setCurso(asignacion.getCurso());
        return this.asignacionAsignaturaRepository.saveAsignacion(existingAsignacion.get());
    }
    @Override
    public void deleteAsignacionById(Integer id) {
        this.asignacionAsignaturaRepository.deleteAsignacionById(id);
    }
}

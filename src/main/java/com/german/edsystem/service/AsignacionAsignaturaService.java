package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.AsignacionAsignaturaRepository;
import com.german.edsystem.models.AsignacionAsignatura;
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
    public AsignacionAsignatura saveAsignacion(AsignacionAsignatura asignacionAsignatura) {
        return this.asignacionAsignaturaRepository.saveAsignacion(asignacionAsignatura);
    }

    @Override
    public void deleteAsignacionById(Integer id) {
        this.asignacionAsignaturaRepository.deleteAsignacionById(id);
    }
}

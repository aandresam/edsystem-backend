package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.AsignaturaRepository;
import com.german.edsystem.models.Asignatura;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AsignaturaService implements IAsignaturaService {
    private final AsignaturaRepository asignaturaRepository;
    @Override
    public Iterable<Asignatura> getAsignaturas() {
        return this.asignaturaRepository.getAsignaturas();
    }

    @Override
    public Optional<Asignatura> getAsignatura(Integer id) {
        return this.asignaturaRepository.getAsignaturaById(id);
    }
    @Override
    public Asignatura saveAsignatura(Asignatura asignatura) {
        return this.asignaturaRepository.saveAsignatura(asignatura);
    }
    @Override
    public void deleteAsignaturaById(Integer id) {
        this.asignaturaRepository.deleteAsignaturaById(id);
    }
}

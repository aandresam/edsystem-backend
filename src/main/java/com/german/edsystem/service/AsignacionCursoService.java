package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.AsignacionCursoRepository;
import com.german.edsystem.models.AsignacionCurso;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AsignacionCursoService implements IAsignacionCursoService {

    private final AsignacionCursoRepository asignacionCursoRepository;
    @Override
    public List<AsignacionCurso> getAsignaciones() {
        return this.asignacionCursoRepository.getAsignaciones();
    }
    @Override
    public AsignacionCurso getAsignacion(Integer id) {
        return this.asignacionCursoRepository.getAsignacionById(id);
    }
    @Override
    public AsignacionCurso saveAsignacion(AsignacionCurso asignacion) {
        return this.asignacionCursoRepository.saveAsignacion(asignacion);
    }
    @Override
    public void deleteAsignacionById(Integer id) {
        this.asignacionCursoRepository.deleteAsignacionById(id);
    }
}

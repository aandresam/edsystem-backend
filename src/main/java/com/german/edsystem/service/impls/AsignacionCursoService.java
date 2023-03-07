package com.german.edsystem.service.impls;

import com.german.edsystem.infrastructure.repository.AsignacionCursoRepository;
import com.german.edsystem.models.AsignacionCurso;
import com.german.edsystem.service.IAsignacionCursoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AsignacionCursoService implements IAsignacionCursoService {

    private final AsignacionCursoRepository asignacionCursoRepository;
    @Override
    public Iterable<AsignacionCurso> getAsignaciones() {
        return this.asignacionCursoRepository.getAsignaciones();
    }
    @Override
    public Optional<AsignacionCurso> getAsignacion(Integer id) {
        return this.asignacionCursoRepository.getAsignacionById(id);
    }
    @Override
    public AsignacionCurso createAsignacion(AsignacionCurso asignacion) {
        return this.asignacionCursoRepository.saveAsignacion(asignacion);
    }
    @Override
    public AsignacionCurso updateAsignacion(AsignacionCurso asignacion){
        Optional<AsignacionCurso> existingAsignacion = this.asignacionCursoRepository
                                                                    .getAsignacionById(asignacion.getIdAsignacion());
        if (existingAsignacion.isEmpty()) {
            return null;
        }
        existingAsignacion.get().setDocente(asignacion.getDocente());
        existingAsignacion.get().setAlumno(asignacion.getAlumno());
        existingAsignacion.get().setHorario(asignacion.getHorario());
        return this.asignacionCursoRepository.saveAsignacion(existingAsignacion.get());
    }
    @Override
    public void deleteAsignacionById(Integer id) {
        this.asignacionCursoRepository.deleteAsignacionById(id);
    }
}

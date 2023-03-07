package com.german.edsystem.service.impls;

import com.german.edsystem.infrastructure.repository.AsignaturaRepository;
import com.german.edsystem.models.Asignatura;
import com.german.edsystem.service.IAsignaturaService;
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
    public Asignatura createAsignatura(Asignatura asignatura) {
        return this.asignaturaRepository.saveAsignatura(asignatura);
    }
    @Override
    public Asignatura updateAsignatura(Asignatura asignatura) {
        Optional<Asignatura> existingAsignatura = this.asignaturaRepository
                                                        .getAsignaturaById(asignatura.getIdAsignatura());
        if (existingAsignatura.isEmpty()) {
            return null;
        }
        existingAsignatura.get().setNombre(asignatura.getNombre());
        return this.asignaturaRepository.saveAsignatura(existingAsignatura.get());
    }
    @Override
    public void deleteAsignaturaById(Integer id) {
        this.asignaturaRepository.deleteAsignaturaById(id);
    }
}

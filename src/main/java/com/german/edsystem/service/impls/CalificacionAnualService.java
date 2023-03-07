package com.german.edsystem.service.impls;

import com.german.edsystem.infrastructure.repository.CalificacionAnualRepository;
import com.german.edsystem.models.CalificacionAnual;
import com.german.edsystem.models.PeriodoAcademico;
import com.german.edsystem.service.ICalificacionAnualService;
import com.german.edsystem.utils.Operaciones;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CalificacionAnualService implements ICalificacionAnualService {
    private final CalificacionAnualRepository calificacionAnualRepository;
    private final PeriodoAcademicoService periodoAcademicoService;
    @Override
    public Iterable<CalificacionAnual> getCalificaciones() {
        return this.calificacionAnualRepository.getCalificaciones();
    }

    @Override
    public Optional<CalificacionAnual> getCalificacionById(Integer id) {
        return this.calificacionAnualRepository.getCalificacionById(id);
    }

    @Override
    public CalificacionAnual createCalificacion(CalificacionAnual calificacion) {
        return this.calificacionAnualRepository.saveCalificacion(calificacion);
    }
    @Override
    public CalificacionAnual updateCalificacion(CalificacionAnual calificacion) {
        Optional<CalificacionAnual> existingCalificacion = this.calificacionAnualRepository
                                                                    .getCalificacionById(calificacion.getId());
        if (existingCalificacion.isEmpty()) {
            return null;
        }
        PeriodoAcademico periodoActivo = this.periodoAcademicoService.getPeriodoByIsActive();
        existingCalificacion.get().setAlumno(calificacion.getAlumno());
        existingCalificacion.get().setAsignatura(calificacion.getAsignatura());
        return this.calificacionAnualRepository.saveCalificacion(existingCalificacion.get());
    }
    @Override
    public void deleteCalificacionById(Integer id) {
        this.calificacionAnualRepository.deleteCalificacionById(id);
    }
}

package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.CalificacionAnualRepository;
import com.german.edsystem.models.CalificacionAnual;
import com.german.edsystem.utils.Operaciones;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CalificacionAnualService implements ICalificacionAnualService {
    private final CalificacionAnualRepository calificacionAnualRepository;
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
        existingCalificacion.get().setAlumno(calificacion.getAlumno());
        existingCalificacion.get().setAsignatura(calificacion.getAsignatura());
        existingCalificacion.get().setPeriodo1(calificacion.getPeriodo1());
        existingCalificacion.get().setPeriodo2(calificacion.getPeriodo2());
        existingCalificacion.get().setPeriodo3(calificacion.getPeriodo3());
        existingCalificacion.get().setPeriodo4(calificacion.getPeriodo4());
        Double[] notas = {
                existingCalificacion.get().getPeriodo1(),
                existingCalificacion.get().getPeriodo2(),
                existingCalificacion.get().getPeriodo3(),
                existingCalificacion.get().getPeriodo4()
        };
        double notaFinal = Operaciones.calcularPromedio(notas);
        existingCalificacion.get().setNotaFinalAnual(notaFinal);
        return this.calificacionAnualRepository.saveCalificacion(existingCalificacion.get());
    }
    @Override
    public void deleteCalificacionById(Integer id) {
        this.calificacionAnualRepository.deleteCalificacionById(id);
    }
}

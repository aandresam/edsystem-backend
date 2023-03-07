package com.german.edsystem.service.impls;

import com.german.edsystem.infrastructure.repository.CalificacionAnualRepository;
import com.german.edsystem.infrastructure.repository.CalificacionRepository;
import com.german.edsystem.infrastructure.repository.PeriodoAcademicoRepository;
import com.german.edsystem.models.Calificacion;
import com.german.edsystem.models.PeriodoAcademico;
import com.german.edsystem.service.ICalificacionService;
import com.german.edsystem.utils.Operaciones;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CalificacionService implements ICalificacionService {

    private final CalificacionRepository calificacionRepository;
    private final PeriodoAcademicoService periodoAcademicoService;
    @Override
    public Iterable<Calificacion> getCalificaciones() {
        return this.calificacionRepository.getCalificaciones();
    }

    @Override
    public Optional<Calificacion> getCalificacionById(Integer id) {
        return this.calificacionRepository.getCalificacionById(id);
    }

    @Override
    public Calificacion createCalificacion(Calificacion calificacion) {
        return this.calificacionRepository.saveCalificacion(calificacion);
    }
    @Override
    public Calificacion updateCalificacion(Calificacion calificacion) {
        Optional<Calificacion> existingCalificacion = this.calificacionRepository
                                                                .getCalificacionById(calificacion.getId());
        if (existingCalificacion.isEmpty()) {
            return null;
        }
        PeriodoAcademico periodoActivo = this.periodoAcademicoService.getPeriodoByIsActive();
        existingCalificacion.get().setAlumno(calificacion.getAlumno());
        existingCalificacion.get().setDocente(calificacion.getDocente());
        existingCalificacion.get().setPeriodoAcademico(periodoActivo);
        existingCalificacion.get().setAsignatura(calificacion.getAsignatura());
        existingCalificacion.get().setNota1(calificacion.getNota1());
        existingCalificacion.get().setNota2(calificacion.getNota2());
        existingCalificacion.get().setNota3(calificacion.getNota3());
        existingCalificacion.get().setNota4(calificacion.getNota4());
        Double[] notas = {
                existingCalificacion.get().getNota1(),
                existingCalificacion.get().getNota2(),
                existingCalificacion.get().getNota3(),
                existingCalificacion.get().getNota4()
        };
        double notaFinal = Operaciones.calcularPromedio(notas);
        existingCalificacion.get().setNotaDefinitiva(notaFinal);
        return this.calificacionRepository.saveCalificacion(existingCalificacion.get());
    }

    @Override
    public void deleteCalificacionById(Integer id) {
        this.calificacionRepository.deleteCalificacionById(id);
    }


}

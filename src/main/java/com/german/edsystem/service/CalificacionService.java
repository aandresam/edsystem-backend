package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.CalificacionRepository;
import com.german.edsystem.models.Calificacion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CalificacionService implements ICalificacionService {

    private final CalificacionRepository calificacionRepository;
    @Override
    public Iterable<Calificacion> getCalificaciones() {
        return this.calificacionRepository.getCalificaciones();
    }

    @Override
    public Optional<Calificacion> getCalificacionById(Integer id) {
        return this.calificacionRepository.getCalificacionById(id);
    }

    @Override
    public Calificacion saveCalificacion(Calificacion calificacion) {
        return this.calificacionRepository.saveCalificacion(calificacion);
    }

    @Override
    public void deleteCalificacionById(Integer id) {
        this.calificacionRepository.deleteCalificacionById(id);
    }

    @Override
    public Calificacion promediarNotaDefinitiva(Calificacion calificacion) {
        Double nota1 = calificacion.getNota1();
        Double nota2 = calificacion.getNota2();
        Double nota3 = calificacion.getNota3();
        Double nota4 = calificacion.getNota4();
        double suma = nota1 + nota2 + nota3 + nota4;
        double notaDefinitiva = (suma == 0) ? 0 : (suma / 4);
        calificacion.setNotaDefinitiva(notaDefinitiva);
        return calificacion;
    }
}

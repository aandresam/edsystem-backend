package com.german.edsystem.controllers;

import com.german.edsystem.models.CalificacionAnual;
import com.german.edsystem.service.ICalificacionAnualService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/calificacion-anual")
public class CalificacionAnualController {
    private final ICalificacionAnualService calificacionAnualService;

    @GetMapping
    public ResponseEntity<Iterable<CalificacionAnual>> getCalificaciones() {
        return new ResponseEntity<>(this.calificacionAnualService.getCalificaciones(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<CalificacionAnual>> getCalificacionAnualById(
            @PathVariable("id") Integer id) {
        Optional<CalificacionAnual> calificacionAnual = this.calificacionAnualService.getCalificacionById(id);
        if (calificacionAnual.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(calificacionAnual, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CalificacionAnual> createCalificacionAnual(
            @RequestBody CalificacionAnual calificacion) {
        return new ResponseEntity<>(this.calificacionAnualService
                .saveCalificacion(calificacion), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CalificacionAnual> updateCalificacionAnual(
            @RequestBody CalificacionAnual calificacion) {
        Optional<CalificacionAnual> existingCalificacion = this.calificacionAnualService
                .getCalificacionById(calificacion.getId());
        if (existingCalificacion.isEmpty()) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingCalificacion.get().setAlumno(calificacion.getAlumno());
        existingCalificacion.get().setAsignatura(calificacion.getAsignatura());
        existingCalificacion.get().setPeriodoAcademico(calificacion.getPeriodoAcademico());
        CalificacionAnual promedioCalificacion = this.calificacionAnualService.promediarCalificacion(existingCalificacion.get());

        return null;
    }

}

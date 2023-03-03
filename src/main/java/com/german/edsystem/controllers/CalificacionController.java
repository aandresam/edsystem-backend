package com.german.edsystem.controllers;

import com.german.edsystem.models.Calificacion;
import com.german.edsystem.service.ICalificacionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/calificaciones")
public class CalificacionController {
    private final ICalificacionService calificacionService;

    @GetMapping
    public ResponseEntity<Iterable<Calificacion>> getCalificaciones(){
        return new ResponseEntity<>(this.calificacionService.getCalificaciones(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Calificacion>> getCalificacionById(@PathVariable("id") Integer id){
        Optional<Calificacion> calificacion = this.calificacionService.getCalificacionById(id);
        if (calificacion.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(calificacion, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Calificacion> createCalificacion(@RequestBody Calificacion calificacion){
        return new ResponseEntity<>(this.calificacionService.saveCalificacion(calificacion), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Calificacion> updateCalificacion(@RequestBody Calificacion calificacion){
        Optional<Calificacion> existingCalificacion = this.calificacionService
                .getCalificacionById(calificacion.getId());
        if (existingCalificacion.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingCalificacion.get().setAlumno(calificacion.getAlumno());
        existingCalificacion.get().setDocente(calificacion.getDocente());
        existingCalificacion.get().setAsignatura(calificacion.getAsignatura());
        existingCalificacion.get().setPeriodoAcademico(calificacion.getPeriodoAcademico());
        existingCalificacion.get().setNota1(calificacion.getNota1());
        existingCalificacion.get().setNota2(calificacion.getNota2());
        existingCalificacion.get().setNota3(calificacion.getNota3());
        existingCalificacion.get().setNota4(calificacion.getNota4());
        Calificacion calificacionPromediada = this.calificacionService
                .promediarNotaDefinitiva(existingCalificacion.get());
        return new ResponseEntity<>(this.calificacionService
                .saveCalificacion(calificacionPromediada), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus deleteCalificacionById(@PathVariable("id") Integer id){
        Optional<Calificacion> calificacion = this.calificacionService.getCalificacionById(id);
        if (calificacion.isEmpty()){
            return HttpStatus.NOT_FOUND;
        }
        this.calificacionService.deleteCalificacionById(calificacion.get().getId());
        return HttpStatus.NO_CONTENT;
    }
}

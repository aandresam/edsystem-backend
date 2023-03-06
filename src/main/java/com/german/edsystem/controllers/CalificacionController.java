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
        return new ResponseEntity<>(this.calificacionService.createCalificacion(calificacion), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Calificacion> updateCalificacion(@RequestBody Calificacion calificacion){
        Calificacion updatedCalificacion = this.calificacionService.updateCalificacion(calificacion);
        if (updatedCalificacion == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedCalificacion, HttpStatus.OK);
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

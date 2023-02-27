package com.german.edsystem.controllers;

import com.german.edsystem.models.AsignacionCurso;
import com.german.edsystem.service.IAsignacionCursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/asignacion-curso")
public class AsignacionCursoController {
    private final IAsignacionCursoService asignacionCursoService;

    @GetMapping
    public ResponseEntity<List<AsignacionCurso>> getAsignaciones() {
        return new ResponseEntity<>(asignacionCursoService.getAsignaciones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionCurso> getAsignacion(@PathVariable("id") Integer id) {
        AsignacionCurso asignacion = asignacionCursoService.getAsignacion(id);
        if (asignacion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asignacion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AsignacionCurso> createAsignacion(@RequestBody AsignacionCurso asignacion) {
        return new ResponseEntity<>(asignacionCursoService
                .saveAsignacion(asignacion), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AsignacionCurso> updateAsignacion(@RequestBody AsignacionCurso asignacion){
        AsignacionCurso existingAsignacion = asignacionCursoService.getAsignacion(asignacion.getIdAsignacion());
        if (existingAsignacion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingAsignacion.setDocente(asignacion.getDocente());
        existingAsignacion.setAlumno(asignacion.getAlumno());
        existingAsignacion.setHorario(asignacion.getHorario());
        return new ResponseEntity<>(asignacionCursoService
                .saveAsignacion(existingAsignacion), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteAsignacion(@PathVariable("id") Integer id) {
        asignacionCursoService.deleteAsignacionById(id);
        return HttpStatus.NO_CONTENT;
    }
}

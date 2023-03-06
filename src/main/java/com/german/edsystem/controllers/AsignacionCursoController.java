package com.german.edsystem.controllers;

import com.german.edsystem.models.AsignacionCurso;
import com.german.edsystem.service.IAsignacionCursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/asignacion-curso")
public class AsignacionCursoController {
    private final IAsignacionCursoService asignacionCursoService;

    @GetMapping
    public ResponseEntity<Iterable<AsignacionCurso>> getAsignaciones() {
        return new ResponseEntity<>(asignacionCursoService.getAsignaciones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AsignacionCurso>> getAsignacionById(@PathVariable("id") Integer id) {
        Optional<AsignacionCurso> asignacion = this.asignacionCursoService.getAsignacion(id);
        if (asignacion.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asignacion, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<AsignacionCurso> createAsignacion(@RequestBody AsignacionCurso asignacion) {
        return new ResponseEntity<>(this.asignacionCursoService
                .createAsignacion(asignacion), HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<AsignacionCurso> updateAsignacion(@RequestBody AsignacionCurso asignacion){
        AsignacionCurso updatedAsignacion = this.asignacionCursoService.updateAsignacion(asignacion);
        if (updatedAsignacion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedAsignacion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public HttpStatus deleteAsignacionById(@PathVariable("id") Integer id) {
        Optional<AsignacionCurso> existingAsignacion = this.asignacionCursoService.getAsignacion(id);
        if (existingAsignacion.isEmpty()) {
            return HttpStatus.NOT_FOUND;
        }
        this.asignacionCursoService.deleteAsignacionById(existingAsignacion.get().getIdAsignacion());
        return HttpStatus.NO_CONTENT;
    }
}

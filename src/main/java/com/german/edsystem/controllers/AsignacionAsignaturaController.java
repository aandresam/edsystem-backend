package com.german.edsystem.controllers;

import com.german.edsystem.models.AsignacionAsignatura;
import com.german.edsystem.service.IAsignacionAsignaturaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/asignacion-asignaturas")
public class AsignacionAsignaturaController {

    private final IAsignacionAsignaturaService asignacionAsignaturaService;

    @GetMapping
    public ResponseEntity<Iterable<AsignacionAsignatura>> getAsignaciones(){
        return new ResponseEntity<>(this.asignacionAsignaturaService.getAsignaciones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AsignacionAsignatura>> getAsignacionById(@PathVariable("id") Integer id){
        Optional<AsignacionAsignatura> asignacion = this.asignacionAsignaturaService.getAsignacionById(id);
        if(asignacion.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asignacion, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<AsignacionAsignatura> createAsignacion(
            @RequestBody AsignacionAsignatura asignacion){
        return new ResponseEntity<>(this.asignacionAsignaturaService
                .createAsignacion(asignacion),HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<AsignacionAsignatura> updateAsignacion(
                                                                @RequestBody AsignacionAsignatura asignacion){
        AsignacionAsignatura asignacionUpdated = this.asignacionAsignaturaService.updateAsignacion(asignacion);
        if (asignacionUpdated == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asignacionUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public HttpStatus deleteAsignacionById(@PathVariable("id") int id){
        Optional<AsignacionAsignatura> existingAsignacion = this.asignacionAsignaturaService
                .getAsignacionById(id);
        if(existingAsignacion.isEmpty()){
            return HttpStatus.NOT_FOUND;
        }
        asignacionAsignaturaService.deleteAsignacionById(existingAsignacion.get().getIdAsignacion());
        return HttpStatus.NO_CONTENT;
    }
}

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
        return new ResponseEntity<>(asignacionAsignaturaService.getAsignaciones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AsignacionAsignatura>> getAsignacionById(@PathVariable("id") Integer id){
        Optional<AsignacionAsignatura> asignacion = asignacionAsignaturaService.getAsignacionById(id);
        if(asignacion.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asignacion, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<AsignacionAsignatura> createAsignacion(
            @RequestBody AsignacionAsignatura asignacion){
        return new ResponseEntity<>(asignacionAsignaturaService
                .saveAsignacion(asignacion),HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<AsignacionAsignatura> updateAsignacion(
            @RequestBody AsignacionAsignatura asignacion){
        Optional<AsignacionAsignatura> existingAsignacion = asignacionAsignaturaService
                .getAsignacionById(asignacion.getIdAsignacion());
        if(existingAsignacion.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingAsignacion.get().setDocente(asignacion.getDocente());
        existingAsignacion.get().setCurso(asignacion.getCurso());
        return new ResponseEntity<>(asignacionAsignaturaService
                .saveAsignacion(existingAsignacion.get()),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public HttpStatus deleteAsignacionById(@PathVariable("id") int id){
        Optional<AsignacionAsignatura> existingAsignacion = asignacionAsignaturaService
                .getAsignacionById(id);
        if(existingAsignacion.isEmpty()){
            return HttpStatus.NOT_FOUND;
        }
        asignacionAsignaturaService.deleteAsignacionById(existingAsignacion.get().getIdAsignacion());
        return HttpStatus.NO_CONTENT;
    }
}

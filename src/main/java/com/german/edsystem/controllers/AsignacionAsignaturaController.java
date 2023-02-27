package com.german.edsystem.controllers;

import com.german.edsystem.models.AsignacionAsignatura;
import com.german.edsystem.service.IAsignacionAsignaturaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/asignacion-asignaturas")
public class AsignacionAsignaturaController {

    private final IAsignacionAsignaturaService asignacionAsignaturaService;

    @GetMapping
    public ResponseEntity<List<AsignacionAsignatura>> getAsignaciones(){
        return new ResponseEntity<>(asignacionAsignaturaService.getAsignaciones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionAsignatura> getAsignacionById(@PathVariable("id") Integer id){
        AsignacionAsignatura asignacion = asignacionAsignaturaService.getAsignacionById(id);
        if(asignacion == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asignacion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AsignacionAsignatura> createAsignacion(
            @RequestBody AsignacionAsignatura asignacion){
        return new ResponseEntity<>(asignacionAsignaturaService
                .saveAsignacion(asignacion),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AsignacionAsignatura> updateAsignacion(
            @RequestBody AsignacionAsignatura asignacion){
        AsignacionAsignatura existingAsignacion = asignacionAsignaturaService
                .getAsignacionById(asignacion.getIdAsignacion());
        if(existingAsignacion == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingAsignacion.setDocente(asignacion.getDocente());
        existingAsignacion.setCurso(asignacion.getCurso());
        return new ResponseEntity<>(asignacionAsignaturaService
                .saveAsignacion(existingAsignacion),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteAsignacion(@PathVariable("id") int id){
        asignacionAsignaturaService.deleteAsignacionById(id);
        return HttpStatus.NO_CONTENT;
    }
}

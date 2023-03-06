package com.german.edsystem.controllers;

import com.german.edsystem.models.Alumno;
import com.german.edsystem.service.IAlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/alumnos")
public class AlumnoController {

    private final IAlumnoService alumnoService;
    @GetMapping
    public ResponseEntity<Iterable<Alumno>> getAlumnos() {
        return new ResponseEntity<>(this.alumnoService.getAlumnos(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Optional<Alumno>> getAlumnoById(@PathVariable Integer id) {
        Optional<Alumno> alumno = this.alumnoService.getAlumnoById(id);
        if(alumno.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(alumno, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
        return new ResponseEntity<>(this.alumnoService.createAlumno(alumno), HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Alumno> updateAlumno(@RequestBody Alumno alumno) {
        Alumno updatedAlumno = this.alumnoService.updateAlumno(alumno);
        if(updatedAlumno == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedAlumno, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public HttpStatus deleteAlumnoById(@PathVariable Integer id) {
        Optional<Alumno> existingAlumno = this.alumnoService.getAlumnoById(id);
        if(existingAlumno.isEmpty()) {
            return HttpStatus.NOT_FOUND;
        }
        this.alumnoService.deleteAlumnoById(existingAlumno.get().getId());
        return HttpStatus.NO_CONTENT;
    }

}

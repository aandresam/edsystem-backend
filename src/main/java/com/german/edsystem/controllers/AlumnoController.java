package com.german.edsystem.controllers;

import com.german.edsystem.models.Alumno;
import com.german.edsystem.service.IAlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/alumnos")
public class AlumnoController {

    private final IAlumnoService alumnoService;
    @GetMapping
    public ResponseEntity<List<Alumno>> listarAlumnos() {
        return new ResponseEntity<>(this.alumnoService.getAlumnos(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> encontrarAlumno(@PathVariable Integer id) {
        Alumno alumno = this.alumnoService.getAlumnoById(id);
        if(alumno == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(alumno, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Alumno> agregarAlumno(@RequestBody Alumno alumno) {
        return new ResponseEntity<>(this.alumnoService.saveAlumno(alumno), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Alumno> modificarAlumno(@RequestBody Alumno alumno) {
        Alumno existingAlumno = this.alumnoService.getAlumnoById(alumno.getId());
        if(existingAlumno == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingAlumno.setNombre(alumno.getNombre());
        existingAlumno.setApellido(alumno.getApellido());
        existingAlumno.setContacto(alumno.getContacto());
        existingAlumno.setDomicilio(alumno.getDomicilio());
        existingAlumno.setFechaNacimiento(alumno.getFechaNacimiento());
        return new ResponseEntity<>(this.alumnoService.saveAlumno(existingAlumno), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus eliminarAlumno(@PathVariable Integer id) {
        this.alumnoService.deleteAlumnoById(id);
        return HttpStatus.NO_CONTENT;
    }

}

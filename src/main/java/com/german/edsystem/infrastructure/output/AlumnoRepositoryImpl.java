package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.AlumnoRepositoryJpa;
import com.german.edsystem.infrastructure.repository.AlumnoRepository;
import com.german.edsystem.models.Alumno;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class AlumnoRepositoryImpl implements AlumnoRepository {
    private final AlumnoRepositoryJpa alumnoRepositoryJpa;

    @Override
    public Iterable<Alumno> getAlumnos() {
        return this.alumnoRepositoryJpa.findAll();
    }
    @Override
    public Optional<Alumno> getAlumnoById(Integer id) {
        Alumno alumno = this.alumnoRepositoryJpa.findById(id).orElse(null);
        return Optional.ofNullable(alumno);
    }
    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return this.alumnoRepositoryJpa.save(alumno);
    }
    @Override
    public void deleteAlumnoById(Integer id) {
        this.alumnoRepositoryJpa.deleteById(id);
    }
}

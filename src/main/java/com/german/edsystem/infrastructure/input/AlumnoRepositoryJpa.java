package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AlumnoRepositoryJpa extends JpaRepository<Alumno, Integer> {
}

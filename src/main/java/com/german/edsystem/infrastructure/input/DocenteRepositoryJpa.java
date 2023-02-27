package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DocenteRepositoryJpa extends JpaRepository<Docente, Integer> {
}

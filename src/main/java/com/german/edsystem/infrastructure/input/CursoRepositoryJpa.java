package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CursoRepositoryJpa extends JpaRepository<Curso, Integer> {
}

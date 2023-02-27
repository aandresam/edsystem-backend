package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface HorarioRepositoryJpa extends JpaRepository<Horario, Integer> {
}

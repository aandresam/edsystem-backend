package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.CalificacionAnual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionAnualRepositoryJpa extends JpaRepository<CalificacionAnual, Integer> {
}

package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositoryJpa extends JpaRepository<Rol, Integer> {
}

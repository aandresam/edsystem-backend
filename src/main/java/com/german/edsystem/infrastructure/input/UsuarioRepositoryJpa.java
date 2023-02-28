package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositoryJpa extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
}

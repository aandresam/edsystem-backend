package com.german.edsystem.infrastructure.input;

import com.german.edsystem.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepositoryJpa extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.username = :username")
    Usuario findByUsername(@Param("username") String username);
}

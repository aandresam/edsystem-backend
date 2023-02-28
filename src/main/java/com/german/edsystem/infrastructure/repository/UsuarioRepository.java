package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> getUsuarioByUsername(String username);
    Iterable<Usuario> getUsuarios();
    Usuario saveUsuario(Usuario usuario);
    void deleteUsuario(Usuario usuario);
}

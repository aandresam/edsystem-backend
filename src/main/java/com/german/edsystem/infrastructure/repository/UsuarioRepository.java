package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario getUsuarioByUsername(String username);
    List<Usuario> getUsuarios();
    Usuario saveUsuario(Usuario usuario);
    void deleteUsuario(Usuario usuario);
}

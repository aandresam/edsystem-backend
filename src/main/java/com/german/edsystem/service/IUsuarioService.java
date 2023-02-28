package com.german.edsystem.service;

import com.german.edsystem.models.Usuario;

import java.util.Optional;

public interface IUsuarioService {
    Optional<Usuario> getUsuarioByUsername(String username);
    Iterable<Usuario> getUsuarios();
    Usuario saveUsuario(Usuario usuario);
    void deleteUsuario(Usuario usuario);
}

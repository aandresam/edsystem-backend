package com.german.edsystem.service;

import com.german.edsystem.models.Usuario;

import java.util.Optional;

public interface IUsuarioService {
    Optional<Usuario> getUsuarioByUsername(String username);
    Iterable<Usuario> getUsuarios();
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(Usuario usuario);
    Usuario updatePassword(Usuario usuario);
    void deleteUsuarioByUsername(Usuario usuario);
}

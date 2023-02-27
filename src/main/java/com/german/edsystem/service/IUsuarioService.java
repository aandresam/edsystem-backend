package com.german.edsystem.service;

import com.german.edsystem.models.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario getUsuarioByUsername(String username);
    List<Usuario> getUsuarios();
    Usuario saveUsuario(Usuario usuario);
    void deleteUsuario(Usuario usuario);
}

package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.UsuarioRepository;
import com.german.edsystem.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> getUsuarioByUsername(String username) {
        return this.usuarioRepository.getUsuarioByUsername(username);
    }
    @Override
    public Iterable<Usuario> getUsuarios() {
        return this.usuarioRepository.getUsuarios();
    }
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return this.usuarioRepository.saveUsuario(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        this.usuarioRepository.deleteUsuario(usuario);
    }
}

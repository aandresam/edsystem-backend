package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.UsuarioRepositoryJpa;
import com.german.edsystem.infrastructure.repository.UsuarioRepository;
import com.german.edsystem.models.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final UsuarioRepositoryJpa usuarioRepositoryJpa;

    @Override
    public Optional<Usuario> getUsuarioByUsername(String username) {
        return this.usuarioRepositoryJpa.findByUsername(username);
    }

    @Override
    public Iterable<Usuario> getUsuarios() {
        return this.usuarioRepositoryJpa.findAll();
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return this.usuarioRepositoryJpa.save(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        this.usuarioRepositoryJpa.delete(usuario);
    }
}

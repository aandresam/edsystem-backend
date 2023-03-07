package com.german.edsystem.service.impls;

import com.german.edsystem.infrastructure.repository.UsuarioRepository;
import com.german.edsystem.models.Usuario;
import com.german.edsystem.service.IUsuarioService;
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
    public Usuario createUsuario(Usuario usuario) {
        return this.usuarioRepository.saveUsuario(usuario);
    }
    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Optional<Usuario> existingUsuario = this.usuarioRepository.getUsuarioByUsername(usuario.getUsername());
        if (existingUsuario.isEmpty()) {
            return null;
        }
        existingUsuario.get().setRol(usuario.getRol());
        existingUsuario.get().setPassword(usuario.getPassword());
        existingUsuario.get().setEnabled(usuario.isEnabled());
        existingUsuario.get().setPersona(usuario.getPersona());
        return this.usuarioRepository.saveUsuario(existingUsuario.get());
    }
    @Override
    public Usuario updatePassword(Usuario usuario) {
        Optional<Usuario> existingUsuario = this.usuarioRepository.getUsuarioByUsername(usuario.getUsername());
        if (existingUsuario.isEmpty()) {
            return null;
        }
        existingUsuario.get().setPassword(usuario.getPassword());
        return this.usuarioRepository.saveUsuario(existingUsuario.get());
    }
    @Override
    public void deleteUsuarioByUsername(Usuario usuario) {
        this.usuarioRepository.deleteUsuario(usuario);
    }
}

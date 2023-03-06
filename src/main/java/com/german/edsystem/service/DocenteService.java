package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.DocenteRepository;
import com.german.edsystem.models.Docente;
import com.german.edsystem.models.Rol;
import com.german.edsystem.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DocenteService implements IDocenteService {
    private final DocenteRepository docenteRepository;
    private final UsuarioService usuarioService;
    private final RolService rolService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Iterable<Docente> getDocentes() {
        return this.docenteRepository.getDocentes();
    }

    @Override
    public Optional<Docente> getDocente(Integer id) {
        return this.docenteRepository.getDocenteById(id);
    }

    @Override
    public Docente createDocente(Docente docente) {
        Docente savedDocente = this.docenteRepository.saveDocente(docente);
        Usuario usuario = createUserForDocente(savedDocente);
        usuario = this.usuarioService.saveUsuario(usuario);
        savedDocente.setUsuario(usuario);
        savedDocente = this.docenteRepository.saveDocente(savedDocente);
        return savedDocente;
    }
    @Override
    public Docente updateDocente(Docente docente) {
        Optional<Docente> existingDocente = this.docenteRepository.getDocenteById(docente.getId());
        if (existingDocente.isEmpty()) {
            return null;
        }
        existingDocente.get().setNombre(docente.getNombre());
        existingDocente.get().setApellido(docente.getApellido());
        existingDocente.get().setContacto(docente.getContacto());
        existingDocente.get().setDomicilio(docente.getDomicilio());
        return this.docenteRepository.saveDocente(existingDocente.get());
    }
    @Override
    public void deleteDocenteById(Integer id) {
        this.docenteRepository.deleteDocenteById(id);
    }

    private Usuario createUserForDocente(Docente docente) {
        Usuario usuario = new Usuario();
        Optional<Rol> rol = this.rolService.getRolById(2);
        usuario.setUsername(docente.getContacto().getEmail());
        usuario.setPassword(this.passwordEncoder.encode(docente.getContacto().getTelefono()));
        usuario.setRol(rol.orElse(null));
        usuario.setEnabled(true);
        usuario.setPersona(docente);
        return usuario;
    }
}

package com.german.edsystem.service.impls;

import com.german.edsystem.infrastructure.repository.AlumnoRepository;
import com.german.edsystem.models.Alumno;
import com.german.edsystem.models.Rol;
import com.german.edsystem.models.Usuario;
import com.german.edsystem.service.IAlumnoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AlumnoService implements IAlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final UsuarioService usuarioService;
    private final RolService rolService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Iterable<Alumno> getAlumnos() {
        return this.alumnoRepository.getAlumnos();
    }
    @Override
    public Optional<Alumno> getAlumnoById(Integer id) {
        return this.alumnoRepository.getAlumnoById(id);
    }
    @Override
    public Alumno createAlumno(Alumno alumno) {
        Alumno savedAlumno = this.alumnoRepository.saveAlumno(alumno);
        Usuario usuario = this.createUserForAlumno(savedAlumno);
        usuario = this.usuarioService.createUsuario(usuario);
        savedAlumno.setUsuario(usuario);
        savedAlumno = this.alumnoRepository.saveAlumno(savedAlumno);
        return savedAlumno;
    }
    @Override
    public Alumno updateAlumno(Alumno alumno) {
        Optional<Alumno> existingAlumno = this.alumnoRepository.getAlumnoById(alumno.getId());
        if (existingAlumno.isEmpty()) {
            return null;
        }
        existingAlumno.get().setNombre(alumno.getNombre());
        existingAlumno.get().setApellido(alumno.getApellido());
        existingAlumno.get().setContacto(alumno.getContacto());
        existingAlumno.get().setDomicilio(alumno.getDomicilio());
        return this.alumnoRepository.saveAlumno(existingAlumno.get());
    }
    @Override
    public void deleteAlumnoById(Integer id) {
        this.alumnoRepository.deleteAlumnoById(id);
    }

    private Usuario createUserForAlumno(Alumno alumno) {
        Usuario usuario = new Usuario();
        Optional<Rol> rol = this.rolService.getRolById(3);
        usuario.setUsername(alumno.getContacto().getEmail());
        usuario.setPassword(this.passwordEncoder.encode(alumno.getContacto().getTelefono()));
        usuario.setRol(rol.orElse(null));
        usuario.setEnabled(true);
        usuario.setPersona(alumno);
        return usuario;
    }

}

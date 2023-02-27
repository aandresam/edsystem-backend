package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.AlumnoRepository;
import com.german.edsystem.models.Alumno;
import com.german.edsystem.models.Rol;
import com.german.edsystem.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AlumnoService implements IAlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final UsuarioService usuarioService;
    private final RolService rolService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Alumno> getAlumnos() {
        return this.alumnoRepository.getAlumnos();
    }
    @Override
    public Alumno getAlumnoById(Integer id) {
        return this.alumnoRepository.getAlumnoById(id);
    }
    @Override
    public Alumno saveAlumno(Alumno alumno) {
        Alumno savedAlumno = this.alumnoRepository.saveAlumno(alumno);
        Usuario usuario = createUserForAlumno(savedAlumno);
        usuario = this.usuarioService.saveUsuario(usuario);
        savedAlumno.setUsuario(usuario);
        savedAlumno = this.alumnoRepository.saveAlumno(savedAlumno);
        return savedAlumno;
    }
    @Override
    public void deleteAlumnoById(Integer id) {
        this.alumnoRepository.deleteAlumnoById(id);
    }

    public Usuario createUserForAlumno(Alumno alumno) {
        Usuario usuario = new Usuario();
        Rol rol = this.rolService.getRolById(3);
        usuario.setUsername(alumno.getContacto().getEmail());
        usuario.setPassword(this.passwordEncoder.encode(alumno.getContacto().getTelefono()));
        usuario.setRol(rol);
        usuario.setEnabled(true);
        usuario.setPersona(alumno);
        return usuario;
    }

}

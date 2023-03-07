package com.german.edsystem.controllers;

import com.german.edsystem.models.Usuario;
import com.german.edsystem.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {
    private final IUsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> getUsuarios() {
        return new ResponseEntity<>(this.usuarioService.getUsuarios(), HttpStatus.OK);
    }
    @GetMapping("/{username}")
    public ResponseEntity<Optional<Usuario>> getUsuarioByUsername(@PathVariable("username") String username) {
        Optional<Usuario> usuario = this.usuarioService.getUsuarioByUsername(username);
        if (usuario.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(this.usuarioService.createUsuario(usuario), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        Usuario updatedUsuario = this.usuarioService.updateUsuario(usuario);
        if (updatedUsuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }
    @PatchMapping
    public ResponseEntity<Usuario> updatePassword(@RequestBody Usuario usuario) {
        Usuario updatedPassword = this.usuarioService.updatePassword(usuario);
        if (updatedPassword == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPassword, HttpStatus.OK);
    }
    @DeleteMapping
    public HttpStatus deleteUsuarioByUsername(@RequestBody Usuario usuario) {
        Optional<Usuario> existingUsuario = this.usuarioService.getUsuarioByUsername(usuario.getUsername());
        if (existingUsuario.isEmpty()) {
            return HttpStatus.NOT_FOUND;
        }
        this.usuarioService.deleteUsuarioByUsername(existingUsuario.get());
        return HttpStatus.NO_CONTENT;
    }
}

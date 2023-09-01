package com.example.demo.controller;

import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/api/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioRepository.getUsuarios();
    }

    @PostMapping("/api/usuario")
    public void registraUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.registrarUsuario(usuario);
    }

    @DeleteMapping("/api/usuario/{id}")
    public void elimiarUsuario(@PathVariable Long id) {
        usuarioRepository.eliminarUsuario(id);
    }

    @PutMapping("/api/usuario/{id}")
    public void modificarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuarioRepository.modificarUsuario(id, usuario);
    }

    @GetMapping("/prueba")
    public String prueba() {
        return "HOLA AUXILIO!";
    }
}

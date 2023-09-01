package com.example.demo.repository;

import com.example.demo.models.Usuario;

import java.util.List;

public interface UsuarioRepository {
    List<Usuario> getUsuarios();

    void registrarUsuario(Usuario usuario);

    void eliminarUsuario(Long id);

    void modificarUsuario(Long id, Usuario usuario);
}

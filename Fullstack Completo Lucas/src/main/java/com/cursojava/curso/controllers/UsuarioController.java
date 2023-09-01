package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Hero");
        usuario.setApellido("Molina");
        usuario.setEmail("hero@hotmail.com");
        usuario.setTelefono("2461234567");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        usuarioDao.eliminar(id);
    }

    //Esto es un ejemplo para enviar una lista de usuaios en formato JSON sin consultar la base de datos aún
    @RequestMapping(value = "usuariov")
    public List<Usuario> getUsuario1() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(123L);
        usuario.setNombre("Juan");
        usuario.setApellido("Molina");
        usuario.setEmail("juan@hotmail.com");
        usuario.setTelefono("2461234567");

        Usuario usuario2 = new Usuario();
        usuario2.setId(456L);
        usuario2.setNombre("Carmina");
        usuario2.setApellido("Salas");
        usuario2.setEmail("carmina@hotmail.com");
        usuario2.setTelefono("2461234567");

        Usuario usuario3 = new Usuario();
        usuario3.setId(789L);
        usuario3.setNombre("Dani");
        usuario3.setApellido("Roldi");
        usuario3.setEmail("rkt@gmail.com");
        usuario3.setTelefono("1231234567");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;
    }

    @RequestMapping(value = "useredit")
    public Usuario editar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juna");
        usuario.setApellido("Molina");
        usuario.setEmail("juan@hotmail.com");
        usuario.setTelefono("2461234567");
        return usuario;
    }

    @RequestMapping(value = "userfind")
    public Usuario buscar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Molina");
        usuario.setEmail("juan@hotmail.com");
        usuario.setTelefono("2461234567");
        return usuario;
    }

}


package com.example.demo.repository;

import com.example.demo.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioRepositoryImp implements UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        List<Usuario> respuesta = entityManager.createQuery(query).getResultList();
        return respuesta;
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void modificarUsuario(Long id, Usuario usuario) {
        Usuario usuarioAct = entityManager.find(Usuario.class, id);

        usuarioAct.setNombre(usuario.getNombre());
        usuarioAct.setApellido(usuario.getApellido());
        usuarioAct.setTelefono(usuario.getTelefono());
        usuarioAct.setEmail(usuario.getEmail());
        usuarioAct.setPassword(usuario.getPassword());

        entityManager.merge(usuarioAct);
    }
}

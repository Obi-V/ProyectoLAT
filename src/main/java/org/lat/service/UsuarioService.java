package org.lat.service;

import lombok.RequiredArgsConstructor;
import org.lat.Repository.CursoRepository;
import org.lat.Repository.UsuarioRepository;
import org.lat.auth.UpdateRequest;
import org.lat.domain.Curso;
import org.lat.domain.Role;
import org.lat.domain.Usuario;
import org.lat.exception.UsuarioNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public List<Usuario> all() {
        return this.usuarioRepository.findAll();
    }

    public Usuario one(Long id) {
        return this.usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    public Usuario replace(Long id, Usuario usuario) {

        return this.usuarioRepository.findById(id).map( p -> (id.equals(usuario.getId())  ?
                        this.usuarioRepository.save(usuario) : null))
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    public Usuario updateUsuario(Long id, UpdateRequest updateRequest) {
        Optional<Usuario> userOptional = usuarioRepository.findById(id);
        if (userOptional.isPresent()) {
            Usuario user = userOptional.get();
            user.setPais(updateRequest.getPais());
            user.setRespuesta(updateRequest.getRespuesta());
            user.setDescripcion(updateRequest.getDescripcion());
            user.setImg(updateRequest.getImg());
            user.setSubtitulo(updateRequest.getSubtitulo());
            user.setHabilidades(updateRequest.getHabilidades());
            user.setIdiomas(updateRequest.getIdiomas());
            return usuarioRepository.save(user);
        }
        return null;
    }

    public Usuario blockUsuario(Long id, UpdateRequest updateRequest) {
        Optional<Usuario> userOptional = usuarioRepository.findById(id);
        if (userOptional.isPresent()) {
            Usuario user = userOptional.get();
            user.setRole(updateRequest.getRole());
            return usuarioRepository.save(user);
        }
        return null;
    }

    public void delete(Long id) {
        this.usuarioRepository.findById(id).map(p -> {this.usuarioRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }
    @Transactional
    public Collection<Curso> getCursos(String name){
        Usuario usuario = usuarioRepository.findByUsername(name).orElse(null);
        if (usuario != null) {
            return usuario.getCursos();
        }else {
            return null;
        }
    }
    @Transactional //Pone el .save()
    public Collection<Curso> addCursos(String name, Long idCurso){
        Usuario usuario = usuarioRepository.findByUsername(name).orElse(null);
        Curso curso = cursoRepository.findById(idCurso).orElse(null);

        if (usuario != null && curso != null) {
            usuario.getCursos().add(curso);
            curso.getUsuarios().add(usuario);
            return usuario.getCursos();
        }else {
            return null;
        }
    }
    @Transactional
    public void removeAllCursos(Long idUser) {
        Usuario usuario = usuarioRepository.findById(idUser).orElse(null);

        if (usuario != null) {
            // Obtener la lista actual de cursos del usuario
            Collection<Curso> cursosActuales = usuario.getCursos();

            // Iterar sobre la lista de cursos y eliminar la asociación
            for (Curso curso : cursosActuales) {
                curso.getUsuarios().remove(usuario);
            }

            // Limpiar la lista de cursos del usuario
            cursosActuales.clear();

            // Guardar los cambios en la base de datos
            usuarioRepository.save(usuario);
        }
    }




    //Para obtener un profesor de la base de datos
    public Usuario oneProfe(String username){
        Usuario profe = usuarioRepository.findByUsername(username).orElse(null);
        //Comprobamos que sea un profesor no se vamos a dar cualquier usuario
        if( profe.getRole().equals(Role.PROFESOR)){
            return  profe;
        }
        return null;
    }
}

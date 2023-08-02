package org.lat.service;

import lombok.RequiredArgsConstructor;
import org.lat.Repository.UsuarioRepository;
import org.lat.domain.Curso;
import org.lat.domain.Usuario;
import org.lat.exception.UsuarioNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


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

    public void delete(Long id) {
        this.usuarioRepository.findById(id).map(p -> {this.usuarioRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    public List<Curso> getCursos(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario != null) {
            return usuario.getCursos();
        }else {
            return null;
        }
    }
}

package org.lat.service;

import org.lat.Repository.UsuarioRepository;
import org.lat.domain.Usuario;
import org.lat.exception.UsuarioNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> all() {
        return this.usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
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
}

package org.lat.service;

import org.lat.Repository.UsuarioRepository;
import org.lat.domain.Rol;
import org.lat.domain.Usuario;
import org.lat.exception.UsuarioNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final List<Rol> rolesPermitidos;

    public UsuarioService(UsuarioRepository usuarioRepository) {

        rolesPermitidos = new ArrayList<>();
        rolesPermitidos.add(Rol.ALUMNO);
        rolesPermitidos.add(Rol.PROFESOR);

        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> all() {
        return this.usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {

        if(rolesPermitidos.contains(usuario.getRol()) ){
        return this.usuarioRepository.save(usuario);
        } else{
            throw new RuntimeException("Rol no admitido");
        }
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


    public List<Usuario> usuariosByIdAsc(String nombre){
        // return this.usuarioRepository.findByNombreContainingIgnoreCaseOrderByIdAsc(nombre);
        return this.usuarioRepository.buscarPorNombre(nombre);
    }
}

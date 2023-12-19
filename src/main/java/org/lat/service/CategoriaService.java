package org.lat.service;

import lombok.RequiredArgsConstructor;
import org.lat.Repository.CategoriaRepository;
import org.lat.Repository.UsuarioRepository;
import org.lat.auth.UpdateRequest;
import org.lat.domain.Categoria;
import org.lat.domain.Role;
import org.lat.domain.Usuario;
import org.lat.exception.CategoriaNotFoundException;
import org.lat.exception.UsuarioNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> all() {
        return this.categoriaRepository.findAll();
    }

    public Categoria one(Long id) {
        return this.categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public Categoria replace(Long id, Categoria categoria) {

        return this.categoriaRepository.findById(id).map( p -> (id.equals(categoria.getId())  ?
                        this.categoriaRepository.save(categoria) : null))
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public Categoria updateCategoria(Long id, UpdateRequest updateRequest) {
        /*Optional<Categoria> userOptional = categoriaRepository.findById(id);
        if (userOptional.isPresent()) {
            Categoria user = userOptional.get();
            user.setPais(updateRequest.getPais());
            user.setRespuesta(updateRequest.getRespuesta());
            user.setDescripcion(updateRequest.getDescripcion());
            user.setImg(updateRequest.getImg());
            user.setSubtitulo(updateRequest.getSubtitulo());
            user.setHabilidades(updateRequest.getHabilidades());
            user.setIdiomas(updateRequest.getIdiomas());
            return usuarioRepository.save(user);*/
        return null;
      //  }
       // return null;
    }

    public void delete(Long id) {
        this.categoriaRepository.findById(id).map(p -> {this.categoriaRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }


}

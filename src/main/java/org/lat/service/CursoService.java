package org.lat.service;


import lombok.RequiredArgsConstructor;
import org.lat.domain.Curso;
import org.lat.domain.Video;
import org.lat.Repository.CursoRepository;
import org.lat.exception.UsuarioNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    public List<Curso> all() {
        return this.cursoRepository.findAll();
    }

    public Curso save(Curso curso) {
        return this.cursoRepository.save(curso);
    }

    public Curso one(Long id) {
        return this.cursoRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    public Curso replace(Long id, Curso curso) {

        return this.cursoRepository.findById(id).map( p -> (id.equals(curso.getId())  ?
                        this.cursoRepository.save(curso) : null))
                .orElseThrow(() -> new UsuarioNotFoundException(id));

    }

    public void delete(Long id) {
        this.cursoRepository.findById(id).map(p -> {this.cursoRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }
}

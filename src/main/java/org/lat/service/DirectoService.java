package org.lat.service;


import org.lat.Repository.DirectoRepository;
import org.lat.domain.Directo;
import org.lat.exception.UsuarioNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoService {

    private final DirectoRepository directoRepository;

    public DirectoService(DirectoRepository directoRepository) {
        this.directoRepository = directoRepository;
    }

    public List<Directo> all() {
        return this.directoRepository.findAll();
    }

    public Directo save(Directo directo) {
        return this.directoRepository.save(directo);
    }

    public Directo one(Long id) {
        return this.directoRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    public Directo replace(Long id, Directo directo) {

        return this.directoRepository.findById(id).map( p -> (id.equals(directo.getId())  ?
                        this.directoRepository.save(directo) : null))
                .orElseThrow(() -> new UsuarioNotFoundException(id));

    }

    public void delete(Long id) {
        this.directoRepository.findById(id).map(p -> {this.directoRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }
}

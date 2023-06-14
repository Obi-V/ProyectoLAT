package org.lat.controller;

import lombok.extern.slf4j.Slf4j;
import org.lat.domain.Rol;
import org.lat.domain.Usuario;
import org.lat.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/lat/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }

    //Get All
    @GetMapping({"", "/"})
    public List<Usuario> all() {
        log.info("Accediendo a todas las películas");
        return this.usuarioService.all();
    }

    //Post Crear
    @PostMapping({"", "/"})
    public Usuario newUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.save(usuario);
    }

    //Get One por ID
    @GetMapping("/{id}")
    public Usuario one(@PathVariable("id") Long id) {
        return this.usuarioService.one(id);
    }

    //Update por ID
    @PutMapping("/{id}")
    public Usuario replaceUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        return this.usuarioService.replace(id, usuario);
    }

    //Delete por ID
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable("id") Long id) {
        this.usuarioService.delete(id);
    }

    @GetMapping("/buscar/{nombre}")
    public List<Usuario> buscarUsuarioByNombre(@PathVariable("nombre") String nombre) {
        return this.usuarioService.usuariosByIdAsc(nombre);
    }

}

package org.lat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lat.auth.UpdateRequest;
import org.lat.domain.Curso;
import org.lat.domain.Usuario;
import org.lat.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/lat/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    @GetMapping({"","/"})
    public List<Usuario> getAll() {
        return this.usuarioService.all();
    }
    //Get One por ID
    @GetMapping("/{id}")
    public Usuario one(@PathVariable("id") Long id) {
        return this.usuarioService.one(id);
    }

    //Update por ID
    @PutMapping("/{id}")
    public Usuario replaceUsuario(@PathVariable("id") Long id, @RequestBody UpdateRequest updateRequest) {
        return this.usuarioService.updateUsuario(id, updateRequest);
    }

    @PutMapping("/block/{id}")
    public Usuario blockUsuario(@PathVariable("id") Long id, @RequestBody UpdateRequest updateRequest) {
        return this.usuarioService.blockUsuario(id, updateRequest);
    }

    //Delete por ID
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable("id") Long id) {
        this.usuarioService.delete(id);
    }

    @GetMapping("/cursos/{username}")
    public Collection<Curso> getCursosDeUsuario(@PathVariable String username) {
        return usuarioService.getCursos(username);
    }

    @PostMapping("/cursos/{username}/{idCurso}")
    public Collection<Curso> addCursosDeUsuario(@PathVariable String username, @PathVariable Long idCurso) {
        return usuarioService.addCursos(username, idCurso);
    }

    @DeleteMapping("/cursos/{idUser}")
    public ResponseEntity<Void> removeAllCursos(@PathVariable Long idUser) {
        log.info("Received request to delete cursos for user with id: {}", idUser);

        usuarioService.removeAllCursos(idUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/profesor/{profeName}")
    public Usuario getProfe(@PathVariable String profeName){
        return usuarioService.oneProfe(profeName);
    }
}

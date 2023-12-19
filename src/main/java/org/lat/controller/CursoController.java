package org.lat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lat.domain.Curso;
import org.lat.domain.Directo;
import org.lat.service.CursoService;
import org.lat.service.DirectoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/lat/curso")
@RequiredArgsConstructor
public class CursoController {
    private final CursoService cursoService;

    //Get getAll
    @GetMapping({"", "/"})
    public List<Curso> getAll() {
        return this.cursoService.all();
    }

    //Post Crear
    @PostMapping({"", "/"})
    public Curso newCurso(@RequestBody Curso curso) {
        return this.cursoService.save(curso);
    }

    //Get One por ID
    @GetMapping("/{id}")
    public Curso one(@PathVariable("id") Long id) {
        return this.cursoService.one(id);
    }

    //Update por ID
    @PutMapping("/{id}")
    public Curso replaceDirecto(@PathVariable("id") Long id, @RequestBody Curso curso) {
        return this.cursoService.replace(id, curso);
    }

    //Delete por ID
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable("id") Long id) {
        this.cursoService.delete(id);
    }
}

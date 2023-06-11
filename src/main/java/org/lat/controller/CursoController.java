package org.lat.controller;

import lombok.extern.slf4j.Slf4j;
import org.lat.domain.Directo;
import org.lat.service.DirectoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/lat/cursos")
public class CursoController {
    private final DirectoService directoService;

    public CursoController(DirectoService directoService) {
        this.directoService = directoService;
    }

    //Get All
    @GetMapping({"", "/"})
    public List<Directo> all() {
        log.info("Accediendo a todas los directos");
        return this.directoService.all();
    }

    //Post Crear
    @PostMapping({"", "/"})
    public Directo newDirecto(@RequestBody Directo directo) {
        return this.directoService.save(directo);
    }

    //Get One por ID
    @GetMapping("/{id}")
    public Directo one(@PathVariable("id") Long id) {
        return this.directoService.one(id);
    }

    //Update por ID
    @PutMapping("/{id}")
    public Directo replaceDirecto(@PathVariable("id") Long id, @RequestBody Directo directo) {
        return this.directoService.replace(id, directo);
    }

    //Delete por ID
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteDirecto(@PathVariable("id") Long id) {
        this.directoService.delete(id);
    }
}

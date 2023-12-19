package org.lat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lat.auth.UpdateRequest;
import org.lat.domain.Categoria;
import org.lat.domain.Usuario;
import org.lat.service.CategoriaService;
import org.lat.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/lat/categoria")
public class CategoriaController {
    private final org.lat.service.CategoriaService categoriaService;
    @GetMapping({"","/"})
    public List<Categoria> getAll() {
        return this.categoriaService.all();
    }

    //Get One por ID
    @GetMapping("/{id}")
    public Categoria one(@PathVariable("id") Long id) {
        return this.categoriaService.one(id);
    }

    //Update por ID
    @PutMapping("/{id}")
    public Categoria replaceCategoria(@PathVariable("id") Long id, @RequestBody UpdateRequest updateRequest) {
        return this.categoriaService.updateCategoria(id, updateRequest);
    }

    //Delete por ID
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable("id") Long id) {
        this.categoriaService.delete(id);
    }


}

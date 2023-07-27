package org.lat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lat.domain.Curso;
import org.lat.domain.Directo;
import org.lat.domain.Usuario;
import org.lat.domain.Video;
import org.lat.service.CursoService;
import org.lat.service.DirectoService;
import org.lat.service.UsuarioService;
import org.lat.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UsuarioService usuarioService;
    private final CursoService   cursoService;
    private final DirectoService directoService;
    private final VideoService videoService;



    @GetMapping({"/usuarios"})
    public List<Usuario> allUsuarios() {
        return this.usuarioService.all();
    }

    @GetMapping({"/cursos"})
    public List<Curso> allCursos() {
        return this.cursoService.all();
    }

    @GetMapping({"/directos"})
    public List<Directo> allDirectos() {
        return this.directoService.all();
    }

    @GetMapping({"/videos"})
    public List<Video> allVideos() {
        return this.videoService.all();
    }




}

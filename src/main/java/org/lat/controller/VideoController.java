package org.lat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lat.domain.Usuario;
import org.lat.domain.Video;
import org.lat.service.UsuarioService;
import org.lat.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/lat/videos")
public class VideoController {
    private final VideoService videoService;

    //Post Crear
    @PostMapping({"", "/"})
    public Video newVideo(@RequestBody Video video) {
        return this.videoService.save(video);
    }

    //Get One por ID
    @GetMapping("/{id}")
    public Video one(@PathVariable("id") Long id) {
        return this.videoService.one(id);
    }

    //Update por ID
    @PutMapping("/{id}")
    public Video replaceVideo(@PathVariable("id") Long id, @RequestBody Video video) {
        return this.videoService.replace(id, video);
    }

    //Delete por ID
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteVideo(@PathVariable("id") Long id) {
        this.videoService.delete(id);
    }
}

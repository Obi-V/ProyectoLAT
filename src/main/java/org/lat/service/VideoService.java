package org.lat.service;


import org.lat.Repository.VideoRepository;
import org.lat.domain.Video;
import org.lat.exception.UsuarioNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> all() {
        return this.videoRepository.findAll();
    }

    public Video save(Video video) {
        return this.videoRepository.save(video);
    }

    public Video one(Long id) {
        return this.videoRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    public Video replace(Long id, Video video) {

        return this.videoRepository.findById(id).map( p -> (id.equals(video.getId())  ?
                        this.videoRepository.save(video) : null))
                .orElseThrow(() -> new UsuarioNotFoundException(id));

    }

    public void delete(Long id) {
        this.videoRepository.findById(id).map(p -> {this.videoRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }
}

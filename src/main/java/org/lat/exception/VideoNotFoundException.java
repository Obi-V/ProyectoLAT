package org.lat.exception;

public class VideoNotFoundException extends RuntimeException{
    public VideoNotFoundException(Long id) { super("Not found Video with id: " + id); }
}

package org.lat.exception;

public class CategoriaNotFoundException extends RuntimeException{
    public CategoriaNotFoundException(Long id) { super("Not found categoria with id: " + id); }
}

package org.lat.exception;

public class CursoNotFoundException extends RuntimeException{
    public CursoNotFoundException(Long id) { super("Not found Curso with id: " + id); }
}

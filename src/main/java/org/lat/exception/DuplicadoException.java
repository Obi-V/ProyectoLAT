package org.lat.exception;

public class DuplicadoException extends RuntimeException {

    public DuplicadoException(String mensaje) {
        super(mensaje);
    }
}
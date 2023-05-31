package org.lat.exception;

public class DirectoNotFoundException extends RuntimeException{
    public DirectoNotFoundException(Long id) { super("Not found Directo with id: " + id); }
}

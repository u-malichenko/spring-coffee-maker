package ru.malichenko.spring.coffee.maker.exceptions;

public class ResourceCreationException extends RuntimeException {
    public ResourceCreationException(String message) {
        super(message);
    }
}

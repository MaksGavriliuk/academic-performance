package org.example.academicperformance.exceptions;


public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Не удалось найти ресурс");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
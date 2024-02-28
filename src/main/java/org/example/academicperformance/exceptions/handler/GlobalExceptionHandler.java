package org.example.academicperformance.exceptions.handler;


import org.example.academicperformance.exceptions.ErrorResponse;
import org.example.academicperformance.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFoundException(NotFoundException exception) {
        return new ErrorResponse("NOT_FOUND", exception.getMessage());
    }

}

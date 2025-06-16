package com.mirante.upcare.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.handlers.errors.Error;
import com.mirante.upcare.handlers.errors.ValidationError;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 400
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Error handle(MethodArgumentNotValidException ex) {

        return new ValidationError((ex
            .getBindingResult().getFieldErrors()
            .stream().map(error -> new ValidationError.InvalidField(
                error.getField(), error.getDefaultMessage()
            ))
            .toList()
        ));

    }

    // 404
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Error entityNotFound(NotFoundException ex) {
        return Error.notFound(ex.getMessage());
    }

    // 500
    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Error globalHandler(Exception ex) {
        return Error.internalServerError(ex.getMessage());
    }
}

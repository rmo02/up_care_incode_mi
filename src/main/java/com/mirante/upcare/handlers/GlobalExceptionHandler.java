package com.mirante.upcare.handlers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Error readable(HttpMessageNotReadableException ex) {
        return Error.badRequest(ex.getMessage());
    }

    // 404
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Error entityNotFound(NotFoundException ex) {
        return Error.notFound(ex.getMessage());
    }

    // 409
    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Error conflict(DataIntegrityViolationException ex) {
        return Error.conflict(ex.getMessage());
    }

    // 500
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Error globalHandler(Exception ex) {
        return Error.internalServerError(ex.getMessage());
    }
}

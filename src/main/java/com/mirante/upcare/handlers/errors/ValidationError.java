package com.mirante.upcare.handlers.errors;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ValidationError extends Error {

    private List<InvalidField> invalidFields;

    public record InvalidField(String field, String description) {}

    public ValidationError(List<InvalidField> invalidFields) {
        super(
            HttpStatus.BAD_REQUEST.value(), 
            HttpStatus.BAD_REQUEST.name(), 
            "Invalid Fields", 
            LocalDateTime.now()
        );

        this.invalidFields = invalidFields;
    }
}

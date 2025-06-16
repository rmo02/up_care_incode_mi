package com.mirante.upcare.handlers.errors;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class Error {

    private Integer code;
    private String status;
    private String message;
    
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    public static Error badRequest(String message) {
        return (Error.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .status(HttpStatus.BAD_REQUEST.name())
            .message(message)
            .build()
        );
    }

    public static Error validationError(List<ValidationError.InvalidField> invalidFields) {
        return new ValidationError(invalidFields);
    }

    public static Error notFound(String message) {
        return (Error.builder()
            .code(HttpStatus.NOT_FOUND.value())
            .status(HttpStatus.NOT_FOUND.name())
            .message(message)
            .build()
        );
    }
    
    public static Error internalServerError(String message) {
        return (Error.builder()
            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
            .message(message)
            .build()
        );
    }
}

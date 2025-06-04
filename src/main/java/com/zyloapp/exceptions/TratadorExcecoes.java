package com.zyloapp.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorExcecoes {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> tratarNotFound(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> tratarOutros(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

package com.fatcorp.workshop_mongo.resources.exception;

import com.fatcorp.workshop_mongo.services.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> NotFound(NotFoundException e, HttpServletRequest request) {
        StandardError error = new StandardError(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                System.currentTimeMillis(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}

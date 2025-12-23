package com.example.demo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ---------- Validation Errors ----------
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        Map<String, Object> response = new HashMap<>();
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Validation Failed");
        response.put("message", errors);
        response.put("path", request.getRequestURI());

        return ResponseEntity.badRequest().body(response);
    }

    // ---------- Bad Request ----------
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequest(
            BadRequestException ex,
            HttpServletRequest request) {

        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, request);
    }

    // ---------- Not Found ----------
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request) {

        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND, request);
    }

    // ---------- Unauthorized ----------
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> handleUnauthorized(
            UnauthorizedException ex,
            HttpServletRequest request) {

        return buildResponse(ex.getMessage(), HttpStatus.UNAUTHORIZED, request);
    }

    // ---------- Fallback ----------
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAll(
            Exception ex,
            HttpServletRequest request) {

        return buildResponse(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }

    // ---------- Common Response Builder ----------
    private ResponseEntity<Map<String, Object>> buildResponse(
            String message,
            HttpStatus status,
            HttpServletRequest request) {

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", status.value());
        response.put("error", status.getReasonPhrase());
        response.put("message", message);
        response.put("path", request.getRequestURI());

        return ResponseEntity.status(status).body(response);
    }
}

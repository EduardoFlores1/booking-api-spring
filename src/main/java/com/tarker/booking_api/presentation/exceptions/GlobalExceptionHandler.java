package com.tarker.booking_api.presentation.exceptions;

import com.tarker.booking_api.core.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ExceptionResponse> handleNotFoundEntity(ModelNotFoundException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(CreateModelException.class)
    @ResponseBody
    public ResponseEntity<ExceptionResponse> handleCreateException(CreateModelException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(UpdateModelException.class)
    @ResponseBody
    public ResponseEntity<ExceptionResponse> handleUpdateException(UpdateModelException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(DeleteModelException.class)
    @ResponseBody
    public ResponseEntity<ExceptionResponse> handleDeleteException(DeleteModelException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ExceptionResponse> handleException(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), "Error: " + ex.getMessage(), request.getDescription(false));
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}

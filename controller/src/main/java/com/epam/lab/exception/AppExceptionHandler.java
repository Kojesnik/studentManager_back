package com.epam.lab.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = InsertException.class)
    public ResponseEntity<Object> handleInsertException(InsertException ex, WebRequest request) {
        return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UpdateException.class)
    public ResponseEntity<Object> handleUpdateException(UpdateException ex, WebRequest request) {
        return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RemoveException.class)
    public ResponseEntity<Object> handleRemoveException(RemoveException ex, WebRequest request) {
        return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = FindException.class)
    public ResponseEntity<Object> handleFindByIdException(FindException ex, WebRequest request) {
        return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

}

package com.Teach3035.crud.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptioDTOReq> notFoundException( ClassNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptioDTOReq(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptioDTOReq> badRequestException(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptioDTOReq(HttpStatus.BAD_REQUEST, e.getMessage()));
    }
}

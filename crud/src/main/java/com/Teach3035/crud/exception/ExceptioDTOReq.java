package com.Teach3035.crud.exception;

import org.springframework.http.HttpStatus;

public record ExceptioDTOReq(HttpStatus status, String message) {
}

package com.crud.mapper.config;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(DuplicateKeyException.class)
  public ResponseEntity<ResponseApi<Void>> handleDuplicateKeyException(DuplicateKeyException duplicate) {
    return ResponseConfig.ResponseApi.error(HttpStatus.CONFLICT, duplicate.getMessage());
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ResponseApi<Void>> handleIllegalArgumentException(IllegalArgumentException illegal) {
    return ResponseConfig.ResponseApi.error(HttpStatus.BAD_REQUEST, "Bad request in: " + illegal.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseApi<Void>> handleException(Exception e) {
    return ResponseConfig.ResponseApi.error(HttpStatus.INTERNAL_SERVER_ERROR, "Have Wrong in: " + e.getMessage());
  }

}

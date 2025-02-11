package com.crud.mapper.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseConfig {
    public static class ResponseApi {
        // Success Response get
        public static <T> ResponseEntity<com.crud.mapper.config.ResponseApi<T>> successGet(String message, T data) {
            return ResponseEntity.ok(com.crud.mapper.config.ResponseApi.buildResponse(HttpStatus.OK, message, data));
        }

        // Success Response
        public static <T> ResponseEntity<com.crud.mapper.config.ResponseApi<T>> successCreate(String message, T data) {
            return ResponseEntity.status(HttpStatus.CREATED).body(com.crud.mapper.config.ResponseApi.buildResponse(HttpStatus.CREATED, message, data));
        }

        // Error Response
        public static ResponseEntity<com.crud.mapper.config.ResponseApi<Void>> error(HttpStatus status, String message) {
            return ResponseEntity.status(status).body(com.crud.mapper.config.ResponseApi.buildResponse(status, message, null));
        }
    }
}

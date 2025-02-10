package com.crud.mapper.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ResponseConfig {
    public static class ResponseApi {
        private static <T> ResponseEntity<T> getResponseEntity(int code, HttpStatus status, String msg, LocalDateTime times, T data) {
            if (times == null) {
                times = LocalDateTime.now();
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            Map<String, Object> bodyCreate = new HashMap<>();
            bodyCreate.put("code", code);
            bodyCreate.put("status", status);
            bodyCreate.put("message", msg);
            bodyCreate.put("timestamp", times.format(formatter));

            Map<String, Object> response = new HashMap<>();
            response.put("body", bodyCreate);
            response.put("data", data);

            return new ResponseEntity(response, status);
        }

        public static <T> ResponseEntity<T> successGet(int code, HttpStatus status, String msg, LocalDateTime times, T data) {
            return getResponseEntity(code, status, msg, times, data);
        }

        public static <T> ResponseEntity<T> successCreate(int code, HttpStatus status, String msg, LocalDateTime times, T data) {
            return getResponseEntity(code, status, msg, times, data);
        }

        public static <T> ResponseEntity<T> error(int code, HttpStatus status, String msg, LocalDateTime times) {
            return getResponseEntity(code, status, msg, times, null);
        }
    }
}

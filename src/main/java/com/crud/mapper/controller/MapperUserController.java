package com.crud.mapper.controller;

import com.crud.mapper.config.ResponseConfig;
import com.crud.mapper.data.request.user.CreateDataUserRequest;
import com.crud.mapper.entity.Users;
import com.crud.mapper.service.user.MapperUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class MapperUserController {
    private final MapperUserService mapperUserService;

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody CreateDataUserRequest req) {
        try {
            Users newUser = mapperUserService.createUser(req);
            return  ResponseConfig.ResponseApi.successCreate(HttpStatus.CREATED.value(), HttpStatus.CREATED, "Success Create User!", req.getCreatedAt(), newUser);
        } catch (Exception e) {
            return ResponseConfig.ResponseApi.error(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, e.getMessage(), LocalDateTime.now());
        }
    }
}

package com.crud.mapper.controller;

import com.crud.mapper.config.ResponseApi;
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
    public ResponseEntity<ResponseApi<Object>> createUser(@Valid @RequestBody CreateDataUserRequest req) {
        Users newUser = mapperUserService.createUser(req);
        return ResponseConfig.ResponseApi.successCreate("new user created!", newUser);
    }
}

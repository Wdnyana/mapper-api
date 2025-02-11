package com.crud.mapper.service.user.command;

import com.crud.mapper.data.request.user.CreateDataUserRequest;
import com.crud.mapper.entity.Users;
import com.crud.mapper.mappers.IUserMapper;
import com.crud.mapper.repository.users.MapperUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CreateMapperUserService {
    private final MapperUserRepository mapperUserRepository;

    private final IUserMapper userMapper;

    public Users createNewUser(CreateDataUserRequest request) {
        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("Username is Required!");
        }

        Optional<Users> userExist = mapperUserRepository.existsByUsername(request.getUsername());
        if (userExist.isPresent()) throw  new DuplicateKeyException("Username already exists");

        Users add = userMapper.saveNewUser(request);
        add.setCreatedAt(LocalDateTime.now());

        mapperUserRepository.save(add);
        return add;
    }
}

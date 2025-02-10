package com.crud.mapper.service.user;

import com.crud.mapper.data.request.user.CreateDataUserRequest;
import com.crud.mapper.entity.Users;
import com.crud.mapper.interfaces.IMapperUserInterface;
import com.crud.mapper.service.user.command.CreateMapperUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapperUserService implements IMapperUserInterface {
    private final CreateMapperUserService createMapperUserService;

    @Override
    public Users createUser(CreateDataUserRequest user) {
        return createMapperUserService.createNewUser(user);
    }
}

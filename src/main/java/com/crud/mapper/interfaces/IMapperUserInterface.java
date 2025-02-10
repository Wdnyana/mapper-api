package com.crud.mapper.interfaces;

import com.crud.mapper.data.request.user.CreateDataUserRequest;
import com.crud.mapper.entity.Users;

public interface IMapperUserInterface {
    Users createUser(CreateDataUserRequest user);
}

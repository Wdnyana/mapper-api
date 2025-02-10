package com.crud.mapper.mappers;
import com.crud.mapper.data.request.user.CreateDataUserRequest;
import com.crud.mapper.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Mapper(componentModel = "spring")
public interface IUserMapper {
    Users saveNewUser(CreateDataUserRequest request);

    @Named("convertDateToString")
    default String convertDateToString(LocalDateTime date) {
        if (date == null) {
            date = LocalDateTime.now();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return date.format(formatter);
    }
}

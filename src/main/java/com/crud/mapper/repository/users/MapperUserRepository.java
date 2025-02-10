package com.crud.mapper.repository.users;

import com.crud.mapper.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapperUserRepository extends
        MongoRepository<Users, String>,
        MapperUserRepositoryExtend {

    boolean existsByUsername(String username);
}

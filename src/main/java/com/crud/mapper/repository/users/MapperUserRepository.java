package com.crud.mapper.repository.users;

import com.crud.mapper.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MapperUserRepository extends
        MongoRepository<Users, String>,
        MapperUserRepositoryExtend {

    @Query("{'username' : {$regex: ?0, $options: 'i'}}")
    Optional<Users> existsByUsername(String username);
}

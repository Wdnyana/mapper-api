package com.crud.mapper.repository.todos;

import com.crud.mapper.entity.Todos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapperTodosRepository extends
        MongoRepository<Todos, String>,
        MapperTodosRepositoryExtend{
}

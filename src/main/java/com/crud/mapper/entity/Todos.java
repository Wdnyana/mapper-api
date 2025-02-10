package com.crud.mapper.entity;

import com.crud.mapper.enums.TaskPriority;
import com.crud.mapper.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document(collection = "todos")
public class Todos {
    @Id
    @JsonProperty("ids")
    private String _id;
    private String userId;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;

    @Field(name = "due_date")
    @JsonProperty("dueDate")
    private LocalDateTime dueDate;

    @Field(name = "created_at")
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @Field(name = "updated_at")
    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;

    @Field(name = "deleted_at")
    @JsonProperty("deletedAt")
    private LocalDateTime deletedAt;
}

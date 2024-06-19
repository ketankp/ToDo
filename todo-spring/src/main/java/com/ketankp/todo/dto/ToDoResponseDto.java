package com.ketankp.todo.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToDoResponseDto {

    private String title;
    private String description;
    private boolean completed;
    private Timestamp createdDate;

}

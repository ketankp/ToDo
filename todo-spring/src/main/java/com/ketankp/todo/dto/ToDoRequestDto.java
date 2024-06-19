package com.ketankp.todo.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToDoRequestDto {

    private String title;
    private String description;

}

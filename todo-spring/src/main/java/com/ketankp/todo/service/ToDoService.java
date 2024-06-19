package com.ketankp.todo.service;

import com.ketankp.todo.dto.ToDoRequestDto;
import com.ketankp.todo.dto.ToDoResponseDto;

import java.util.List;

public interface ToDoService {

    public List<String> getToDoTitleList();
    public ToDoResponseDto getToDoDetailsByTile(String title);
    public ToDoResponseDto createToDo(ToDoRequestDto toDoDto);

}

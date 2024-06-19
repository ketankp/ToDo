package com.ketankp.todo.controller;

import com.ketankp.todo.dto.ToDoRequestDto;
import com.ketankp.todo.dto.ToDoResponseDto;
import com.ketankp.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getToDoTitleList(){
        log.info("ToDoController:getToDoTitleList method started");
        return toDoService.getToDoTitleList();
    }

    @GetMapping("{title}")
    @ResponseStatus(HttpStatus.OK)
    public ToDoResponseDto getToDoDetailsByTile(@PathVariable("title") String title){
        log.info("ToDoController:getToDoDetailsByTitle");
        return toDoService.getToDoDetailsByTile(title);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoResponseDto createToDo(@RequestBody ToDoRequestDto toDoDto){
        log.info("ToDoController:createToDo method started");
        return toDoService.createToDo(toDoDto);
    }
}

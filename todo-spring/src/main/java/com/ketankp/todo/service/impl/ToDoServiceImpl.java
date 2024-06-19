package com.ketankp.todo.service.impl;

import com.ketankp.todo.dto.ToDoRequestDto;
import com.ketankp.todo.dto.ToDoResponseDto;
import com.ketankp.todo.entity.ToDo;
import com.ketankp.todo.exception.CustomNotFoundException;
import com.ketankp.todo.repository.ToDoRepository;
import com.ketankp.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    @Override
    public List<String> getToDoTitleList() {
        return toDoRepository.getToDoTitleList();
    }

    @Override
    public ToDoResponseDto getToDoDetailsByTile(String title) {
        ToDo toDo = toDoRepository.findByTitle(title);
        if(toDo == null){
            throw new CustomNotFoundException("ToDo not found with title: " + title);
        }else{
            return ToDoResponseDto.builder()
                    .title(toDo.getTitle())
                    .description(toDo.getDescription())
                    .createdDate(toDo.getCreatedDate())
                    .completed(toDo.isCompleted())
                    .build();
        }
    }

    @Override
    public ToDoResponseDto createToDo(ToDoRequestDto toDoDto) {
        ToDo toDo = new ToDo();
        toDo.setCompleted(toDo.isCompleted());
        toDo.setDescription(toDoDto.getDescription());
        toDo.setTitle(toDoDto.getTitle());
        toDo.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        ToDo savedToDo = toDoRepository.save(toDo);

        ModelMapper mapper = new ModelMapper();
        return mapper.map(savedToDo,ToDoResponseDto.class);
    }
}

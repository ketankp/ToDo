package com.ketankp.todo.repository;

import com.ketankp.todo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Integer> {

    @Query("SELECT title from ToDo")
    public List<String> getToDoTitleList();

    public ToDo findByTitle(String title);
}

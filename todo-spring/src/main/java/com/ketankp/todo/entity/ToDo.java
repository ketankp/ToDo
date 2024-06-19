package com.ketankp.todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo_list")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String title;
    public String description;
    public Timestamp createdDate;
    public boolean completed = false;

}

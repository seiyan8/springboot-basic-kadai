package com.example.springkadaitodo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "todos")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String priority;

    private String status;
}
package com.example.springkadaitodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todo")
    public String showTodoList(Model model) {
        model.addAttribute("todoList", toDoService.findAll());
        return "todoView";
    }
}

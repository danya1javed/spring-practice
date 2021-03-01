package com.springpractice.project01.controller;

import com.springpractice.project01.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@SessionAttributes("username")
public class TodoController {
  @Autowired
  TodoService service;

//  show todos
  @GetMapping("/list-todos")
  public String showTodos(ModelMap model){
    String username = (String) model.getAttribute("username");
    model.put("todos", service.retrieveTodos(username));
    return "list-todo";
  }

  @PostMapping("/list-todos")
  public String addTodo(
          @RequestParam String desc,
//          @RequestParam Date targetDate,
//          @RequestParam boolean isDone,
          ModelMap model
  ) {
//    service.addTodo((String) model.getAttribute("username"), desc, targetDate, isDone);
    service.addTodo((String) model.getAttribute("username"), desc, new Date(), false);
    return "redirect:/list-todos";
  }

  @GetMapping("/delete-todo")
  public String deleteTodo(@RequestParam int id) {
    service.deleteTodo(id);
    return "redirect:/list-todos";
  }
}

package com.springpractice.project01.controller;

import com.springpractice.project01.model.Todo;
import com.springpractice.project01.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("username")
public class TodoController {
  @Autowired
  TodoService service;

  @InitBinder
  public void initBinder(WebDataBinder binder){
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(date, false));
  }

//  show todos
  @GetMapping("/list-todos")
  public String showTodos(ModelMap model){
    String username = getUsername(model);
    model.put("todos", service.retrieveTodos(username));
    return "list-todo";
  }

  private String getUsername(ModelMap model) {
    return (String) model.getAttribute("username");
  }

  @GetMapping("/add-todo")
  public String showAddTodoPage(ModelMap model) {
    model.addAttribute("todo", new Todo(0, (String) model.get("name"), "Default Desc",
            new Date(), false));
    return "todo";
  }

  @PostMapping("/add-todo")
  public String addTodo(
          ModelMap model,
          @Valid Todo todo,
          BindingResult result
  ) {
    if(result.hasErrors()){
      return "todo";
    }
    service.addTodo((String) model.getAttribute("username"), todo.getDesc(), todo.getTargetDate(), false);
    return "redirect:/list-todos";
  }

  @GetMapping("/update-todo")
  public String showUpdatePage(@RequestParam int id, ModelMap model){
    model.put("todo", service.retrieveTodo(id));
    return "todo";
  }

  @PostMapping("/update-todo")
  public String updateTodo(
          ModelMap model,
         @Valid Todo todo,
         BindingResult result
  ) {
    if(result.hasErrors()){
      return "todo";
    }
    todo.setUser((String) model.getAttribute("username"));
    service.updateTODO(todo);
    return "redirect:/list-todos";
  }

  @GetMapping("/delete-todo")
  public String deleteTodo(@RequestParam int id) {
    service.deleteTodo(id);
    return "redirect:/list-todos";
  }
}

/*
* Bean - form Binding
* 1. use spring form tag library in jsp and rewrite the form using tag 'form'
* 2. add Todo object in parameter in addTodo to enable direct binding to it.
* 3. create a default model attribute named 'todo' so that application doesn't crash
*    require a default constructor as well in todo.
* 4. in JSP form using modelAttribute on the form links bean and form.
* 5. for validation add dependency javax.validation if not already present.
* */
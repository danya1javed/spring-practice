package com.springpractice.project01.service;

import com.springpractice.project01.model.Todo;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class TodoService {
  private static List<Todo> todoDB = new ArrayList<Todo>();

  static {
    todoDB.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(),
            false));
    todoDB.add(new Todo(2, "in28Minutes", "Learn Struts", new Date(), false));
    todoDB.add(new Todo(3, "timcook", "Learn Hibernate", new Date(),
            false));
  }

//  retrieveTODO
  public List<Todo> retrieveTodos (String user){
    System.out.println( todoDB
            .stream()
            .filter(obj -> obj.getUser().equalsIgnoreCase(user))
            .collect(Collectors.toList()));
    return todoDB
            .stream()
            .filter(obj -> obj.getUser().equalsIgnoreCase(user))
            .collect(Collectors.toList());
  }

//  addTODO
  public void addTodo(
          String name,
          String desc,
          Date targetDate,
          boolean isDone
  ){
    todoDB.add(new Todo(todoDB.size() + 1, name, desc, targetDate, isDone));
  }

//  deleteTODO
  public void deleteTodo (int id){
    todoDB.removeIf(todo -> todo.getId() == id);
  }
}

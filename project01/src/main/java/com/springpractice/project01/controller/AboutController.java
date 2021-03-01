package com.springpractice.project01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // mandatory to make class a controller
public class AboutController {
  @GetMapping("/about") // define the method type
  public String aboutMessage(
          @RequestParam String name,
          @RequestParam int age,
          @RequestParam char gender,
          @RequestParam double height,
          @RequestParam(name="address") String longAddress, // just to show that param name & local name can be diff.
          ModelMap model
  ){
    model.put("name", name);
    model.put("age", age);
    model.put("gender", gender);
    model.put("height", height);
    model.put("longAddress", longAddress);
    return "about"; // tells which jsp to load with help prefix and suffix
  }
}

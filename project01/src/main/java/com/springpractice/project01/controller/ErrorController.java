package com.springpractice.project01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller("error")
public class ErrorController {
  @ExceptionHandler(Exception.class)
  public ModelAndView handleException(HttpServletRequest request, Exception ex) {
    ModelAndView mv = new ModelAndView();
    System.out.println("Error"+ex.getLocalizedMessage() + request.getRequestURL());
    mv.addObject("exception", ex.getLocalizedMessage());
    mv.addObject("url", request.getRequestURL());
    mv.setViewName("error");
    return mv;
  }
}

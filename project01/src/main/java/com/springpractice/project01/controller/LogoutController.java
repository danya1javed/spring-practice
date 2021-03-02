package com.springpractice.project01.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogoutController {

  @GetMapping("/logout")
  public String logout(HttpServletRequest request,
                       HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext()
            .getAuthentication(); // get auth user
    if (auth != null) { // if user present logout and redirect
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/";
  }
}

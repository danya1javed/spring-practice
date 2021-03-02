package com.springpractice.project01.controller;

import com.springpractice.project01.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sun.plugin.liveconnect.SecurityContextHelper;

@Controller
@SessionAttributes("username")
public class LoginController {
  /*
    LoginService service = new LoginService();
    never do this. its defeats the purpose of spring
    Don't create instance yourself
    use spring autowired and component
   */
//  @Autowired
//  LoginService service;

  private String getLoggedInUser (){
    Object Principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if(Principal instanceof UserDetails){
      return ((UserDetails) Principal).getUsername();
    }
    return Principal.toString();
  }

  @GetMapping("/")
  public String welcome(ModelMap model){
    model.put("username", getLoggedInUser());
    return "welcome";
  }

//  @GetMapping("/login")
//  public String showLogin(){
//    return "login";
//  }

//  @PostMapping("/login")
//  public String showWelcome(
//          @RequestParam String username,
//          @RequestParam String password,
//          ModelMap model
//  ){
//    if(!service.checkCredentials(username, password)){
//      return "login";
//    }
//    model.put("username",username);
//    return "welcome";
//  }
}

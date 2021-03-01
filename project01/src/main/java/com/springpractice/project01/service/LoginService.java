package com.springpractice.project01.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
  public boolean checkCredentials(String username, String password){
    return username.equalsIgnoreCase("timCook") && password.equals("qwert123");
  }
}

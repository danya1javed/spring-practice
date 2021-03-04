package com.springpractice.project01.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class securityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
          throws Exception {
//    String password = encoder().encode("yourPassword");
//    added multiple users in memory
    auth.inMemoryAuthentication()
            .withUser("timcook")
            .password(encoder().encode("qwert1234"))
            .roles("USER", "ADMIN");
    auth.inMemoryAuthentication()
            .withUser("timo")
            .password(encoder().encode("qwert123"))
            .roles("USER", "ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/login", "/h2-console/**").permitAll()
            .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
            .formLogin();

    http.csrf().disable();
    http.headers().frameOptions().disable();
  }

  @Bean
  public PasswordEncoder encoder(){
    return new BCryptPasswordEncoder();
  }
}
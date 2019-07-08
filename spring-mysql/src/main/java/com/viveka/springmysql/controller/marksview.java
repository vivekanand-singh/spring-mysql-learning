package com.viveka.springmysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/marks")
public class marksview {
  @GetMapping()
  public String greet() {
    return "marks";
  }

  @GetMapping("/findAll")
  public String getAll() {
    return "marksAll";
  }
}

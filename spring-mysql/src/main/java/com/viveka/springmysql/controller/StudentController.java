package com.viveka.springmysql.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viveka.springmysql.model.StudentInfo;
import com.viveka.springmysql.repository.StudentRepository;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
  @Autowired
  StudentRepository studentRepo;



  @GetMapping(value = "/all")
  List<StudentInfo> getAll() {
    return studentRepo.findAll();
  }

  @GetMapping(value = "/{roll}")
  StudentInfo getRoll(@PathVariable long roll) {
    if (studentRepo.findById(roll) == null)
      throw new RuntimeException("id not found");
    System.out.println(studentRepo.findById(roll));
    return studentRepo.findById(roll);
  }

  @PostMapping(value = "/insert")
  StudentInfo insert(@RequestBody StudentInfo std) {
    studentRepo.save(std);
    return studentRepo.findById(std.getRollNumber());
  }

  @PutMapping(value = "/update/{roll}")
  StudentInfo update(@RequestBody StudentInfo std, @PathVariable Long roll) {
    std.setRollNumber(roll);
    studentRepo.save(std);
    return studentRepo.findByName(std.getName());
  }

  @DeleteMapping(value = "/delete/{roll}")
  String delete(@PathVariable long roll) {
    studentRepo.deleteById(roll);
    return "Deleated";
  }

}

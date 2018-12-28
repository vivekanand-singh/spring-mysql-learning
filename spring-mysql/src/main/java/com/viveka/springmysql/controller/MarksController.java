package com.viveka.springmysql.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viveka.springmysql.model.MarksInfo;
import com.viveka.springmysql.repository.MarksRepository;

@RestController
@RequestMapping(value = "/marks")
public class MarksController {
  @Autowired
  MarksRepository marksRepo;
  @Autowired
  StudentController student;

  @GetMapping(value = "/all")
  List<MarksInfo> getAll() {
    return marksRepo.findAll();
  }

  @GetMapping(value = "/{roll}")
  List<MarksInfo> getByroll(@PathVariable long roll) {
    return marksRepo.findById(roll);
  }

  @PostMapping(value = "/insert")
  List<MarksInfo> insert(@RequestBody MarksInfo marks) {
    long roll = marks.getStd().getRollNumber();
    marks.setStd(student.getRoll(roll));
    marksRepo.save(marks);
    return marksRepo.findById(marks.getMarksId());
  }

  @PutMapping(value = "/update/{roll}")
  List<MarksInfo> update(@PathVariable long roll, @RequestBody MarksInfo marks) {

    marks.setStd(student.getRoll(roll));
    marksRepo.save(marks);
    return marksRepo.findById(roll);
  }
}

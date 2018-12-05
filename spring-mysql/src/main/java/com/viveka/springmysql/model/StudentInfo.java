package com.viveka.springmysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudentInfo {
  @Id
  @GeneratedValue
  @Column(name = "rollNumber")
  long rollNumber;
  @Column(name = "name")
  String name;
  @Column(name = "branch")
  String branch;
}

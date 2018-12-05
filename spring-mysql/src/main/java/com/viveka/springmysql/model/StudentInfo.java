package com.viveka.springmysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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

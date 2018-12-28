package com.viveka.springmysql.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MarksInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "marksId")
  long marksId;
  @Column(name = "subjectName")
  String subjectName;
  @Column(name = "marks")
  long marks;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rollNumber", referencedColumnName = "rollNumber")
  StudentInfo std;
}

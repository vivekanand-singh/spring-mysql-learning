package com.viveka.springmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.viveka.springmysql.model.StudentInfo;

@Component
public interface StudentRepository extends JpaRepository<StudentInfo, Long> {

}

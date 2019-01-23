package com.viveka.springmysql.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.viveka.springmysql.model.StudentInfo;
import com.viveka.springmysql.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {

  MockMvc mockMvc;
  @InjectMocks
  StudentController stdControl;

  @Mock
  StudentRepository stdRepo;

  @Before
  public void initialize() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(stdControl).build();
    stdControl.studentRepo = stdRepo;
  }

  @Test
  public void TestStudentController() throws Exception {


    StudentInfo student = new StudentInfo();
    student.setName("Viveka");
    student.setBranch("IT");
    student.setRollNumber(2);

    when(stdRepo.findById(2)).thenReturn(student);
    mockMvc.perform(get("/student/2")).andExpect(status().isOk());
  }


}

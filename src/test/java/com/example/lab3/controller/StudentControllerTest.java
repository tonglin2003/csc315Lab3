package com.example.lab3.controller;

import com.example.lab3.Student;
import com.example.lab3.StudentController;
import com.example.lab3.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = StudentController.class)
@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    public void init(){
        Student student = new Student();
        student.setStudent_name("Ash");
        student.setAge(15);
    }

    @Test
    public void StudentController_addStudent() throws Exception {
        Student student = new Student();
        student.setStudent_name("Ash");
        student.setAge(15);

        BDDMockito.given(studentRepository.save(ArgumentMatchers.any())).willAnswer((invocation -> invocation.getArgument(0)));

        ResultActions resultActions = mockMvc.perform(post("/addStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)));

        resultActions.andExpect(MockMvcResultMatchers.status().isCreated());

    }

}

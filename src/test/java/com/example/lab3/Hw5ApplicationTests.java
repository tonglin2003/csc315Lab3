package com.example.lab3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Hw5ApplicationTests {

    @Autowired
    private StudentController studentController;

    @Test
    void contextLoads() throws Exception{
        assertThat(studentController).isNotNull();
    }

}

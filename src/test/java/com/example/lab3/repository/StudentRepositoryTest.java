package com.example.lab3.repository;

import com.example.lab3.Lab3Application;
import com.example.lab3.Student;
import com.example.lab3.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Lab3Application.class)
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void StudentRepo_SaveStudent(){
        // Arrange
        Student student = new Student();
        student.setStudent_name("Ash");
        student.setAge(11);
        System.out.println(studentRepository);

        // Act
        Student savedStudent = studentRepository.save(student);

        // Assert
        Assertions.assertThat(savedStudent.getSid()).isGreaterThan(0);
    }

    @Test
    public void findAllStudentTest(){
        // Arrange
        Student student = new Student();
        student.setStudent_name("Ash");
        student.setAge(11);
        studentRepository.save(student);

        // Act
        Iterable<Student> savedStudent = studentRepository.findAll();

        // Assert
        Assertions.assertThat(savedStudent).isNotNull();
    }

    @Test
    public void studentUpdate(){
        // Arrange
        Student student = new Student();
        student.setStudent_name("Ash");
        student.setAge(11);
        studentRepository.save(student);

        // Act
        Student foundStudent = studentRepository.findById(student.getSid()).get();

        student.setStudent_name("Hikari");
        Student updatedStudent = studentRepository.save(student);


        // Assert
        Assertions.assertThat(updatedStudent.getStudent_name()).isEqualTo("Hikari");
    }

    @Test
    public void studentDelete(){
        // Arrange
        Student student = new Student();
        student.setStudent_name("Ash");
        student.setAge(11);
        studentRepository.save(student);

        // Act
        studentRepository.deleteById(student.getSid());
        Optional<Student> foundStudent = studentRepository.findById(student.getSid());

        // Assert
        Assertions.assertThat(foundStudent).isEmpty();
    }

}

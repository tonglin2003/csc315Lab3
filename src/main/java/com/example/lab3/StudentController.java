package com.example.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    // Add student into the database, example link: http://localhost:8080/addStudent
    @PostMapping(path="/addStudent")
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Get all students in the database, example link: http://localhost:8080/addStudent
    @GetMapping(path="/all")
    public ResponseEntity<Iterable<Student>> getAllStudent(){
        Iterable<Student> students = studentRepository.findAll();
        System.out.println(students); // Display the result of selects
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // Get student by sid, example link: http://localhost:8080/sid/1
    @GetMapping(path="/sid/{sid}")
    public ResponseEntity<Student> getStudentBySid(@PathVariable("sid") Integer sid){
        Student student = studentRepository.findAllBySid(sid);
        System.out.println(student); // Display the result of selects
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // Get all students older than an age, example link: http://localhost:8080/studentAgeOlder/10
    @GetMapping(path="/studentAgeOlder/{age}")
    public ResponseEntity<Iterable<Student>> getStudentOlderThan(@PathVariable("age") Integer age){
        Iterable<Student> students = studentRepository.findStudentOlderThan(age);
        System.out.println(students); // Display the result of selects
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}


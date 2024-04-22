package com.example.hw5;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class Hw5Application implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(Hw5Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("Spring boot is running at http://localhost:8080/");
    }

}

package com.example.lab3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.sid = ?1")
    Student findAllBySid(Integer sid);

    @Query("SELECT s FROM Student s WHERE s.age > ?1")
    Iterable<Student> findStudentOlderThan(int age);

}

package com.example.hw5;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.hw5.Student;
public interface StudentRepository extends CrudRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.sid = ?1")
    Student findAllBySid(Integer sid);

    @Query("SELECT s FROM Student s WHERE s.age > ?1")
    Iterable<Student> findStudentOlderThan(int age);

}

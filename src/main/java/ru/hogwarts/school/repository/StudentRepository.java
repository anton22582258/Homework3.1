/*package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Long>{
    List<Student> getByAge(int age);
    List<Student> findByAgeBetween(int minAge, int maxAge);

}*/


package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Long>{
    List<Student> findAllByAge(int age);
    List<Student> findByAgeBetween(int minAge, int maxAge);

}
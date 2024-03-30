package ru.hogwarts.school.service;

import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.exception.StudentNotFoundException;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student) {
        return studentRepository.save(student);
    }


    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    public Student update(Long id, Student student) {
        Student existingStudent = getById(id);
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        studentRepository.save(existingStudent);
        return existingStudent;
    }

    public Student remove(Long id) {
        Student existingStudent = getById(id);
        studentRepository.delete(existingStudent);
        return existingStudent;
    }

    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }
    public Collection<Student> getByAge(int age) {
        return studentRepository.findAllByAge(age);
    }
}


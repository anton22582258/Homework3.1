package ru.hogwarts.school.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.DataNotFoundException;
import ru.hogwarts.school.model.Student;

@Service
public class StudentService {

    private final Map<Long, Student> map = new HashMap<>();
    private Long COUNTER = 1L;

    public Student create(Student student) {
        student.setId(COUNTER++);
        map.put(student.getId(), student);
        return student;
    }

    public Student update(Long id, Student student) {
        if (!map.containsKey(id)) {
            throw new DataNotFoundException();
        }
        Student exsistingStudent = map.get(id);
        exsistingStudent.setName(student.getName());
        exsistingStudent.setAge(student.getAge());
        return exsistingStudent;
    }

    public Collection<Student> getAll() {
        return map.values();
    }

    public void delete(Long id) {
        if (map.remove(id) == null) {
            throw new DataNotFoundException();
        }
    }

    public Student getById(Long id) {
        return map.get(id);
    }

    public Collection<Student> getByAge(int age) {
        return map.values().stream()
                .filter(s -> s.getAge() == age)
                .collect(Collectors.toList());
    }

}


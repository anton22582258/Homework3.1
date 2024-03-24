package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.DataNotFoundException;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final Map<Long, Faculty> map = new HashMap<>();
    private Long COUNTER = 1L;

    public Faculty create(Faculty faculty) {
        faculty.setId(COUNTER++);
        map.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty update(Long id, Faculty faculty) {
        if (!map.containsKey(id)) {
            throw new DataNotFoundException();
        }
        Faculty exsistingFaculty = map.get(id);
        exsistingFaculty.setName(faculty.getName());
        exsistingFaculty.setColor(faculty.getColor());
        return exsistingFaculty;
    }

    public Faculty getById(Long id) {
        return map.get(id);
    }

    public void delete(Long id) {
        if (map.remove(id) == null) {
            throw new DataNotFoundException();
        }
    }

    public Collection<Faculty> getAll() {
        return map.values();
    }

    public Collection<Faculty> getByColor(String color) {
        return map.values().stream()
                .filter(f -> f.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }
}
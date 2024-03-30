package ru.hogwarts.school.service;

import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.exception.FacultyNotFoundException;

import java.util.Collection;
import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(Faculty faculty) {
        return facultyRepository.save(faculty);
    }


    public Faculty getById(Long id) {
        return facultyRepository.findById(id).orElseThrow(FacultyNotFoundException::new);
    }

    public Faculty update(Long id, Faculty faculty) {
        Faculty existingFaculty = getById(id);
        existingFaculty.setName(faculty.getName());
        existingFaculty.setColor(faculty.getColor());
        facultyRepository.save(existingFaculty);
        return existingFaculty;
    }

    public Faculty remove(Long id) {
        Faculty existingFaculty = getById(id);
        facultyRepository.delete(existingFaculty);
        return existingFaculty;
    }

    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }
    public Collection<Faculty> getByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }
}
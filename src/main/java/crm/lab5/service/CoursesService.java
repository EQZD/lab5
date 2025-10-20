package crm.lab5.service;

import crm.lab5.entity.Courses;
import crm.lab5.repository.CoursesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    private final CoursesRepository repository;

    public CoursesService(CoursesRepository repository) {
        this.repository = repository;
    }

    public List<Courses> getAll() {
        return repository.findAll();
    }

    public Courses getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Courses save(Courses course) {
        return repository.save(course);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

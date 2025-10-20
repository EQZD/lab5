package crm.lab5.service;

import crm.lab5.entity.ApplicationRequest;
import crm.lab5.entity.Courses;
import crm.lab5.repository.ApplicationRequestRepository;
import crm.lab5.repository.CoursesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    private final CoursesRepository repository;
    private final ApplicationRequestRepository requestRepository;

    public CoursesService(CoursesRepository repository, ApplicationRequestRepository requestRepository) {
        this.repository = repository;
        this.requestRepository = requestRepository;
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
        List<ApplicationRequest> requestsToDetach = requestRepository.findAllByCourseId(id);

        for (ApplicationRequest req : requestsToDetach) {
            req.setCourse(null);
            requestRepository.save(req);
        }

        repository.deleteById(id);
    }
}
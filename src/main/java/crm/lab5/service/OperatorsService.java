package crm.lab5.service;

import crm.lab5.entity.Operators;
import crm.lab5.repository.OperatorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorsService {

    private final OperatorsRepository repository;

    public OperatorsService(OperatorsRepository repository) {
        this.repository = repository;
    }

    public List<Operators> getAll() {
        return repository.findAll();
    }

    public List<Operators> getAllByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

    public Operators getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Operators save(Operators operator) {
        return repository.save(operator);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

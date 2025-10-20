package crm.lab5.service;

import crm.lab5.entity.Rate;
import crm.lab5.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateService {
    private final RateRepository repository;

    public List<Rate> findAll() {
        return repository.findAll();
    }

    public Rate findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void save(Rate rate) {
        repository.save(rate);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

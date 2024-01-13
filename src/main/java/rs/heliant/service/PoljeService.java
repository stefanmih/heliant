package rs.heliant.service;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import rs.heliant.repository.PoljeRepository;

@Service
public class PoljeService {

    private final PoljeRepository repository;

    private final Mapper mapper;

    public PoljeService(PoljeRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

}

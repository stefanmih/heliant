package rs.heliant.service;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import rs.heliant.repository.StatistikaRepository;

@Service
public class StatistikaService {

    private final StatistikaRepository repository;

    private final Mapper mapper;

    public StatistikaService(StatistikaRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    
}

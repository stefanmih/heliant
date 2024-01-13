package rs.heliant.service;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import rs.heliant.repository.FormularRepository;

@Service
public class FormularService {

    private final FormularRepository repository;

    private final Mapper mapper;

    public FormularService(FormularRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

}

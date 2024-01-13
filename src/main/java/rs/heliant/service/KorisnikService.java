package rs.heliant.service;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import rs.heliant.repository.KorisnikRepository;

@Service
public class KorisnikService {

    private final KorisnikRepository repository;

    private final Mapper mapper;

    public KorisnikService(KorisnikRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    
}

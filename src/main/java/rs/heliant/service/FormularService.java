package rs.heliant.service;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import rs.heliant.dto.FormularDTO;
import rs.heliant.entity.FormularDO;
import rs.heliant.repository.FormularRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormularService {

    private final FormularRepository repository;

    private final Mapper mapper;

    public FormularService(FormularRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<FormularDTO> getAllFormular() {
        List<FormularDTO> formularDTOs = new ArrayList<>();
        for (FormularDO fdo : repository.findAll()) {
            formularDTOs.add(mapper.map(fdo, FormularDTO.class, "FormularDO_FormularDTO"));
        }
        return formularDTOs;
    }

    public FormularDTO getFormular(Integer id) {
        return repository.findById(id).isPresent() ? mapper.map(repository.findById(id).get(), FormularDTO.class, "FormularDO_FormularDTO") : null;
    }
}

package rs.heliant.service;

import org.dozer.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rs.heliant.configuration.CurrentUserConfiguration;
import rs.heliant.dto.FormularDTO;
import rs.heliant.dto.FormularPopunjenDTO;
import rs.heliant.dto.KorisnikDTO;
import rs.heliant.entity.FormularDO;
import rs.heliant.entity.FormularPopunjenDO;
import rs.heliant.repository.FormularRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FormularService {

    private final FormularRepository repository;

    private final CurrentUserConfiguration userConfiguration;

    private final Mapper mapper;

    public FormularService(FormularRepository repository, CurrentUserConfiguration userConfiguration, Mapper mapper) {
        this.repository = repository;
        this.userConfiguration = userConfiguration;
        this.mapper = mapper;
    }


    public List<FormularDTO> getAllFormular(int from, int to) {
        List<FormularDTO> formularDTOs = new ArrayList<>();
        List<FormularDO> formularDOs = repository.findAll();
        int start = from < 0 || from > formularDOs.size() ? 0 : from;
        int end = to > formularDOs.size() || to < start ? formularDOs.size() : to;
        for (int i = start; i < end; i++) {
            formularDTOs.add(mapper.map(formularDOs.get(i), FormularDTO.class, "FormularDO_FormularDTO"));
        }
        return formularDTOs;
    }

    public FormularDTO getFormularById(Integer id) {
        return repository.findById(id).isPresent() ? mapper.map(repository.findById(id).get(), FormularDTO.class, "FormularDO_FormularDTO") : null;
    }

    public FormularDTO getFormularByNaziv(String naziv) {
        List<FormularDTO> formularDTOList = getAllFormular(0, -1).stream().filter(e -> e.getNaziv().equals(naziv)).toList();
        return !formularDTOList.isEmpty() ? formularDTOList.get(0) : null;
    }

    public ResponseEntity<?> insertFormular(FormularDTO formular) {
        try {
            FormularDO fDO = repository.findById(formular.getId()).isPresent() ? repository.findById(formular.getId()).get() : null;
            if (fDO != null) {
                formular.setKorisnikPoslednjiAzurirao(mapper.map(userConfiguration.getLoggedUser(), KorisnikDTO.class));
                formular.setVremeKreiranja(fDO.getVremeKreiranja());
                formular.setKorisnikKreirao(mapper.map(fDO.getKorisnikKreirao(), KorisnikDTO.class));
                formular.setVremePoslednjeIzmeme(new Date());
            } else {
                formular.setKorisnikKreirao(mapper.map(userConfiguration.getLoggedUser(), KorisnikDTO.class));
                formular.setKorisnikPoslednjiAzurirao(mapper.map(userConfiguration.getLoggedUser(), KorisnikDTO.class));
                formular.setVremeKreiranja(new Date());
                formular.setVremePoslednjeIzmeme(new Date());
            }

            int i = 0;
            if(formular.getFormularPopunjen() != null) {
                for (FormularPopunjenDTO formularPopunjenDTO : formular.getFormularPopunjen()) {
                    if(fDO != null && containsFormular(fDO, formularPopunjenDTO)){
                        formularPopunjenDTO.setKorisnikKreirao(mapper.map(fDO.getPolja().get(i).getKorisnikKreirao(), KorisnikDTO.class));
                        formularPopunjenDTO.setKorisnikPoslednjiAzurirao(mapper.map(userConfiguration.getLoggedUser(), KorisnikDTO.class));
                        formularPopunjenDTO.setVremeKreiranja(fDO.getPolja().get(i).getVremeKreiranja());
                        formularPopunjenDTO.setVremePoslednjeIzmeme(new Date());
                    }else {
                        formularPopunjenDTO.setKorisnikKreirao(mapper.map(userConfiguration.getLoggedUser(), KorisnikDTO.class));
                        formularPopunjenDTO.setKorisnikPoslednjiAzurirao(mapper.map(userConfiguration.getLoggedUser(), KorisnikDTO.class));
                        formularPopunjenDTO.setVremeKreiranja(new Date());
                        formularPopunjenDTO.setVremePoslednjeIzmeme(new Date());
                    }
                    i++;
                }
            }
            repository.save(mapper.map(formular, FormularDO.class));
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("not inserted");
        }
    }

    private boolean containsFormular(FormularDO fDO, FormularPopunjenDTO formularPopunjenDTO) {
        return fDO.getPolja() != null && !fDO.getPolja().stream().filter(e->e.getId().equals(formularPopunjenDTO.getId())).toList().isEmpty();
    }
    public ResponseEntity<?> deleteFormular(Integer id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("not deleted");
        }
    }

    public List<FormularPopunjenDO> countFormularPopunjen(){
        List<FormularPopunjenDO> formularPopunjenDTOList = new ArrayList<>();
        for(FormularDO formular : repository.findAll()){
            if(formular.getFormularPopunjen() != null)
                formularPopunjenDTOList.addAll(formular.getFormularPopunjen());
        }
        return formularPopunjenDTOList;
    }

}

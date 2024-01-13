package rs.heliant.service;

import org.dozer.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rs.heliant.configuration.CurrentUserConfiguration;
import rs.heliant.dto.*;
import rs.heliant.entity.PoljeDO;
import rs.heliant.enums.PoljeType;
import rs.heliant.repository.PoljeRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PoljeService {

    private final PoljeRepository repository;

    private final Mapper mapper;

    private final CurrentUserConfiguration userConfiguration;

    public PoljeService(PoljeRepository repository, Mapper mapper, CurrentUserConfiguration userConfiguration) {
        this.repository = repository;
        this.mapper = mapper;
        this.userConfiguration = userConfiguration;
    }

    public List<PoljeDTO> getAllPolje(int from, int to) {
        List<PoljeDTO> poljeDTOs = new ArrayList<>();
        List<PoljeDO> poljeDOs = repository.findAll();
        int start = from < 0 || from > poljeDOs.size() ? 0 : from;
        int end = to > poljeDOs.size() || to < start ? poljeDOs.size() : to;
        for (int i = start; i < end; i++) {
            poljeDTOs.add(mapper.map(poljeDOs.get(i), PoljeDTO.class, "PoljeDO_PoljeDTO"));
        }
        return poljeDTOs;
    }

    public PoljeDTO getPoljeById(Integer id) {
        return repository.findById(id).isPresent() ? mapper.map(repository.findById(id).get(), PoljeDTO.class, "PoljeDO_PoljeDTO") : null;
    }

    public PoljeDTO getPoljeByNaziv(String naziv) {
        List<PoljeDTO> poljeDtoList = getAllPolje(0, -1).stream().filter(e -> e.getNaziv().equals(naziv)).toList();
        return !poljeDtoList.isEmpty() ? poljeDtoList.get(0) : null;
    }

    public ResponseEntity<?> insertPolje(PoljeDTO polje) {
        try {
            PoljeDO pDO = repository.findById(polje.getId()).isPresent() ? repository.findById(polje.getId()).get() : null;
            if (pDO != null) {
                polje.setKorisnikPoslednjiAzurirao(mapper.map(userConfiguration.getLoggedUser(), KorisnikDTO.class));
                polje.setVremeKreiranja(pDO.getVremeKreiranja());
                polje.setKorisnikKreirao(mapper.map(pDO.getKorisnikKreirao(), KorisnikDTO.class));
                polje.setVremePoslednjeIzmeme(new Date());
            } else {
                polje.setKorisnikKreirao(mapper.map(userConfiguration.getLoggedUser(), KorisnikDTO.class));
                polje.setKorisnikPoslednjiAzurirao(mapper.map(userConfiguration.getLoggedUser(), KorisnikDTO.class));
                polje.setVremeKreiranja(new Date());
                polje.setVremePoslednjeIzmeme(new Date());
            }
            int i = 0;
            if(polje.getPolja() != null) {
                for (PoljePopunjenoDTO poljePopunjenoDTO : polje.getPolja()) {
                    if(pDO != null && containsPolje(pDO, poljePopunjenoDTO)){
                        poljePopunjenoDTO.setKorisnikKreirao(mapper.map(pDO.getPolja().get(i).getKorisnikKreirao(), KorisnikDTO.class));
                        poljePopunjenoDTO.setKorisnikPoslednjiAzurirao(mapper.map(userConfiguration.getLoggedUser(), KorisnikDTO.class));
                        poljePopunjenoDTO.setVremeKreiranja(pDO.getPolja().get(i).getVremeKreiranja());
                        poljePopunjenoDTO.setVremePoslednjeIzmeme(new Date());
                    }else {
                        poljePopunjenoDTO.setKorisnikKreirao(mapper.map(userConfiguration.getLoggedUser(), KorisnikDTO.class));
                        poljePopunjenoDTO.setKorisnikPoslednjiAzurirao(mapper.map(userConfiguration.getLoggedUser(), KorisnikDTO.class));
                        poljePopunjenoDTO.setVremeKreiranja(new Date());
                        poljePopunjenoDTO.setVremePoslednjeIzmeme(new Date());
                    }
                    i++;
                }
            }
            if(polje.getPolja() != null){
                for(PoljePopunjenoDTO poljePopunjenoDTO : polje.getPolja()){
                    if(polje.getTip().equals(PoljeType.BROJ)){
                        poljePopunjenoDTO.setVrednostTekst(null);
                    }else{
                        poljePopunjenoDTO.setVrednostBroj(null);
                    }
                }
            }
            repository.save(mapper.map(polje, PoljeDO.class, "PoljeDTO_PoljeDO"));
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("not inserted");
        }
    }

    private boolean containsPolje(PoljeDO pDO, PoljePopunjenoDTO poljePopunjenoDTO) {
        return pDO.getPolja() != null && !pDO.getPolja().stream().filter(e->e.getId().equals(poljePopunjenoDTO.getId())).toList().isEmpty();
    }

    public ResponseEntity<?> deletePolje(Integer id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("not deleted");
        }
    }

}

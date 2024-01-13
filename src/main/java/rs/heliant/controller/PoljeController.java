package rs.heliant.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.heliant.dto.PoljeDTO;
import rs.heliant.service.PoljeService;
import rs.heliant.service.PoljeService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PoljeController {

    private final PoljeService service;

    public PoljeController(PoljeService service) {
        this.service = service;
    }

    @GetMapping("/getAllPolje")
    public List<PoljeDTO> getAllPolje(Integer from, Integer to){
        return service.getAllPolje(from, to);
    }

    @GetMapping("/getPoljeById")
    public PoljeDTO getPoljeById(@Valid @RequestParam Integer id){
        return service.getPoljeById(id);
    }

    @GetMapping("/getPoljeByNaziv")
    public PoljeDTO getPoljeByNaziv(@Valid @RequestParam String naziv){
        return service.getPoljeByNaziv(naziv);
    }

    @PostMapping("/insertUpdatePolje")
    public ResponseEntity<?> insertUpdatePolje(@Valid @RequestBody PoljeDTO Polje){
        return service.insertPolje(Polje);
    }

    @PostMapping("/deletePolje")
    public ResponseEntity<?> deletePolje(@Valid Integer id){
        return service.deletePolje(id);
    }

}

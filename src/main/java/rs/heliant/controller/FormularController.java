package rs.heliant.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.heliant.dto.FormularDTO;
import rs.heliant.service.FormularService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FormularController {

    private final FormularService service;

    public FormularController(FormularService service) {
        this.service = service;
    }

    @GetMapping("/getAllFormular")
    public List<FormularDTO> getAllFormular(Integer from, Integer to){
        return service.getAllFormular(from, to);
    }

    @GetMapping("/getFormularById")
    public FormularDTO getFormularById(@Valid @RequestParam Integer id){
        return service.getFormularById(id);
    }

    @GetMapping("/getFormularByNaziv")
    public FormularDTO getFormularByNaziv(@Valid @RequestParam String naziv){
        return service.getFormularByNaziv(naziv);
    }

    @PostMapping("/insertUpdateFormular")
    public ResponseEntity<?> insertUpdateFormular(@Valid @RequestBody FormularDTO formular){
        return service.insertFormular(formular);
    }

    @PostMapping("/deleteFormular")
    public ResponseEntity<?> deleteFormular(@Valid Integer id){
        return service.deleteFormular(id);
    }

}

package rs.heliant.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class FormularDTO implements Serializable {

    private Integer id;

    private String naziv;

    private Date vremeKreiranja;

    private Date vremePoslednjeIzmeme;

    public KorisnikDTO korisnikKreirao;

    public KorisnikDTO korisnikPoslednjiAzurirao;

    private Set<FormularPopunjenDTO> formularPopunjen;

    private Set<PoljeDTO> polja;

}

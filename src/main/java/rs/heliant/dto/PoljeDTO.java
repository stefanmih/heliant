package rs.heliant.dto;

import lombok.Getter;
import lombok.Setter;
import rs.heliant.enums.PoljeType;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class PoljeDTO implements Serializable {

    private Integer id;

    private String naziv;

    private Integer prikazniRedosled;

    private PoljeType tip;

    private Date vremeKreiranja;

    private Date vremePoslednjeIzmeme;

    public KorisnikDTO korisnikKreirao;

    public KorisnikDTO korisnikPoslednjiAzurirao;

    public FormularDTO formular;


}

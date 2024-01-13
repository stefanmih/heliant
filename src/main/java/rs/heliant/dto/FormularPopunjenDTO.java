package rs.heliant.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class FormularPopunjenDTO implements Serializable {

    private Integer id;

    private Date vremeKreiranja;

    private Date vremePoslednjeIzmeme;

    public KorisnikDTO korisnikKreirao;

    public KorisnikDTO korisnikPoslednjiAzurirao;

    public FormularDTO formular;

}

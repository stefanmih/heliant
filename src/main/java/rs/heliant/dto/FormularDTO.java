package rs.heliant.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class FormularDTO implements Serializable {

    @NotNull
    private Integer id;

    @NotNull
    @NotEmpty
    private String naziv;

    private Date vremeKreiranja;

    private Date vremePoslednjeIzmeme;

    public KorisnikDTO korisnikKreirao;

    public KorisnikDTO korisnikPoslednjiAzurirao;

    private Set<FormularPopunjenDTO> formularPopunjen;

    private Set<PoljeDTO> polja;

}

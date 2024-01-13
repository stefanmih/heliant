package rs.heliant.dto;

import lombok.Getter;
import lombok.Setter;
import rs.heliant.enums.KorisnikRole;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class KorisnikDTO implements Serializable {

    private Integer id;

    private String korisnickoIme;

    private String lozinka;

    private KorisnikRole tip;

    private Date vremeKreiranja;

    private Date vremePoslednjeIzmeme;

    public String getLozinka() {
        return null;
    }
}

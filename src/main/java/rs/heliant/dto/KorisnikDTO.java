package rs.heliant.dto;

import lombok.Getter;
import lombok.Setter;
import rs.heliant.enums.KorisnikRole;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class KorisnikDTO implements Serializable {

    @NotNull
    private Integer id;

    @NotNull
    @NotEmpty
    private String korisnickoIme;

    @NotNull
    @NotEmpty
    private String lozinka;

    @NotNull
    private KorisnikRole tip;

    private Date vremeKreiranja;

    private Date vremePoslednjeIzmeme;

    public String getLozinka() {
        return null;
    }
}

package rs.heliant.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class PoljePopunjenoDTO implements Serializable {

    @NotNull
    private Integer id;

    private Integer vrednostBroj;

    private String vrednostTekst;

    private Date vremeKreiranja;

    private Date vremePoslednjeIzmeme;

    public FormularPopunjenDTO formular;

    public PoljeDTO polje;

    public KorisnikDTO korisnikKreirao;

    public KorisnikDTO korisnikPoslednjiAzurirao;

    @NotNull
    public Integer idFormularPopunjen;

    @NotNull
    public Integer idPolje;

}

package rs.heliant.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class FormularPopunjenDTO implements Serializable {

    @NotNull
    private Integer id;

    private Date vremeKreiranja;

    private Date vremePoslednjeIzmeme;

    @NotNull
    @NotEmpty
    private String idFormular;

    public KorisnikDTO korisnikKreirao;

    public KorisnikDTO korisnikPoslednjiAzurirao;


}

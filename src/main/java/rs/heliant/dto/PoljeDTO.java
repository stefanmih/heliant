package rs.heliant.dto;

import lombok.Getter;
import lombok.Setter;
import rs.heliant.entity.PoljePopunjenoDO;
import rs.heliant.enums.PoljeType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PoljeDTO implements Serializable {

    @NotNull
    private Integer id;

    @NotNull
    @NotEmpty
    private String naziv;

    private Integer prikazniRedosled;

    @NotNull
    private PoljeType tip;

    private Date vremeKreiranja;

    private Date vremePoslednjeIzmeme;

    public KorisnikDTO korisnikKreirao;

    public KorisnikDTO korisnikPoslednjiAzurirao;

    @NotNull
    @NotEmpty
    public String idFormular;

    private List<PoljePopunjenoDTO> polja;


}

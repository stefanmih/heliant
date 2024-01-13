package rs.heliant.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "POLJE_POPUNJENO")
@Getter
@Setter
public class PoljePopunjenoDO implements Serializable {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "VREDNOST_BROJ")
    private Integer vrednostBroj;

    @Column(name = "VREDNOST_TEKST")
    private String vrednostTekst;

    @Column(name = "VREME_KREIRANJA")
    private Date vremeKreiranja;

    @Column(name = "VREME_POSLEDNJE_IZMENE")
    private Date vremePoslednjeIzmeme;

    @Column(name = "ID_FORMULAR_POPUNJEN")
    private Integer idFormularPopunjen;

    @Column(name = "ID_POLJE")
    private Integer idPolje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FORMULAR_POPUNJEN", insertable = false, updatable = false)
    public FormularPopunjenDO formular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_POLJE", insertable = false, updatable = false)
    public PoljeDO polje;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_KORISNIK_KREIRAO")
    public KorisnikDO korisnikKreirao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_KORISNIK_POSLEDNJI_AZURIRAO")
    public KorisnikDO korisnikPoslednjiAzurirao;

    public FormularPopunjenDO getFormular() {
        return null;
    }
    public PoljeDO getPolje() {
        return null;
    }
}

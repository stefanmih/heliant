package rs.heliant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import rs.heliant.enums.PoljeType;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "POLJE")
@Getter
@Setter
public class PoljeDO implements Serializable {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAZIV")
    private String naziv;

    @Column(name = "PRIKAZNI_REDOSLED")
    private Integer prikazniRedosled;

    @Column(name = "TIP")
    @Enumerated(value = EnumType.ORDINAL)
    private PoljeType tip;

    @Column(name = "VREME_KREIRANJA")
    private Date vremeKreiranja;

    @Column(name = "VREME_POSLEDNJE_IZMENE")
    private Date vremePoslednjeIzmeme;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_KORISNIK_KREIRAO")
    public KorisnikDO korisnikKreirao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_KORISNIK_POSLEDNJI_AZURIRAO")
    public KorisnikDO korisnikPoslednjiAzurirao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FORMULAR")
    public FormularDO formular;


}

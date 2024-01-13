package rs.heliant.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "FORMULAR")
@Getter
@Setter
public class FormularDO implements Serializable {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAZIV")
    private String naziv;

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

    @OneToMany(mappedBy = "formular", fetch = FetchType.EAGER)
    private Set<FormularPopunjenDO> formularPopunjen;

    @OneToMany(mappedBy = "formular", fetch = FetchType.EAGER)
    private List<PoljeDO> polja;

}

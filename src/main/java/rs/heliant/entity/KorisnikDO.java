package rs.heliant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import rs.heliant.enums.KorisnikRole;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "KORISNIK")
@Getter
@Setter
public class KorisnikDO implements Serializable {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "KORISNICKO_IME")
    private String korisnickoIme;

    @Column(name = "LOZINKA")
    private String lozinka;

    @Column(name = "TIP")
    @Enumerated(value = EnumType.ORDINAL)
    private KorisnikRole tip;

    @Column(name = "VREME_KREIRANJA")
    private Date vremeKreiranja;

    @Column(name = "VREME_POSLEDNJE_IZMENE")
    private Date vremePoslednjeIzmeme;

}

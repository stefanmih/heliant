package rs.heliant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "STATISTIKA")
@Getter
@Setter
public class StatistikaDO implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DATUM")
    private Date datum;

    @Column(name = "BROJ_POPUNJENIH_FORMULARA")
    private Integer brojPopunjenihFormulara;

    @Column(name = "VREME_KREIRANJA")
    private Date vremeKreiranja;

    @Column(name = "VREME_POSLEDNJE_IZMENE")
    private Date vremePoslednjeIzmeme;
}

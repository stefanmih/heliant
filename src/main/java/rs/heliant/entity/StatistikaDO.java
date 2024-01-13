package rs.heliant.entity;

import javax.persistence.*;
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

}

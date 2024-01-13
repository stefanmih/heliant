package rs.heliant.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class StatistikaDTO implements Serializable {

    private Integer id;

    private Date datum;

    private Integer brojPopunjenihFormulara;

    private Date vremeKreiranja;

    private Date vremePoslednjeIzmeme;
}

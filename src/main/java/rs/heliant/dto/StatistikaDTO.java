package rs.heliant.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class StatistikaDTO implements Serializable {

    @NotNull
    private Integer id;

    @NotNull
    private Date datum;

    @NotNull
    private Integer brojPopunjenihFormulara;

}

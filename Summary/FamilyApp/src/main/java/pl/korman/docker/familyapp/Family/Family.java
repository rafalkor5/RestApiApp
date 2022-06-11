package pl.korman.docker.familyapp.Family;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "family")
@Getter
@Setter
@NoArgsConstructor
public class Family {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank
    @NotNull
    private String familyName;

    @NotNull
    private int nrOfAdults;

    @NotNull
    private int nrOfChildren;

    @NotNull
    private int nrOfInfants;

    public Family(final String familyName, final int nrOfAdults, final int nrOfChildren, final int nrOfInfants) {
        this.familyName = familyName;
        this.nrOfAdults = nrOfAdults;
        this.nrOfChildren = nrOfChildren;
        this.nrOfInfants = nrOfInfants;
    }
}

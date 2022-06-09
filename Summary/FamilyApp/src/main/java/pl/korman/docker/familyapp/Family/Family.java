package pl.korman.docker.familyapp.Family;

import lombok.*;

import javax.persistence.*;

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

    private String familyName;
    private int nrOfAdults;
    private int nrOfChildren;
    private int nrOfInfants;

    public Family(final String familyName, final int nrOfAdults, final int nrOfChildren, final int nrOfInfants) {
        this.familyName = familyName;
        this.nrOfAdults = nrOfAdults;
        this.nrOfChildren = nrOfChildren;
        this.nrOfInfants = nrOfInfants;
    }
}

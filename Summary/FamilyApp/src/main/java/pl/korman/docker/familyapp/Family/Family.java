package pl.korman.docker.familyapp.Family;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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



}

package pl.korman.docker.familymemberapp.FamilyMember;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "familymembers")
@Getter
@Setter
@NoArgsConstructor
public class FamilyMember {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private int familyId;
    private String givenName;
    private String familyName;
    private int age;

}

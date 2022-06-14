package pl.korman.docker.familymemberapp.FamilyMember;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "familymembers")
@Data
@NoArgsConstructor
public class FamilyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotNull
    private int familyId;
    @NotBlank
    @NotNull
    private String givenName;
    @NotBlank
    @NotNull
    private String familyName;
    @NotNull
    private int age;

    public FamilyMember(final int familyId, final String givenName, final String familyName, final int age) {
        this.familyId = familyId;
        this.givenName = givenName;
        this.familyName = familyName;
        this.age = age;
    }

}

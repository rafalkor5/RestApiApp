package pl.korman.docker.familymemberapp.FamilyMember;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "familymembers")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class FamilyMember {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NonNull
    private int familyId;
    @NonNull
    private String givenName;
    @NonNull
    private String familyName;
    @NonNull
    private int age;

}

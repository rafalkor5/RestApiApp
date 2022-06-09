package pl.korman.docker.familyapp.Family.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class FamilyMemberRestOutputDTO {
    private int familyId;
    private String givenName;
    private String familyName;
    private int age;
}

package pl.korman.docker.familyapp.Family.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FamilyMemberRestInputDTO {
    private int familyId;
    private String givenName;
    private String familyName;
    private int age;
    private int id;
}

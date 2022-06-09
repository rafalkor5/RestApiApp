package pl.korman.docker.familymemberapp.FamilyMember.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FamilyMember_CreateDTO {
    private int familyId;
    private String givenName;
    private String familyName;
    private int age;
}

package pl.korman.docker.familymemberapp.FamilyMember.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FamilyMember_CreateDTO {
    @NonNull
    private int familyId;
    private String givenName;
    private String familyName;
    private int age;
}

package pl.korman.docker.familyapp.Family.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Family_MemberCreateDTO {
    private String givenName;
    private String familyName;
    private int age;
}

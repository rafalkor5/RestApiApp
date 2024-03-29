package pl.korman.docker.familyapp.Family.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
public class FamilyOutputDTO {
    private int id;
    private String familyName;
    private int nrOfAdults;
    private int nrOfChildren;
    private int nrOfInfants;
    private List<FamilyMemberRestInputDTO> familyMembersDtoList;
}

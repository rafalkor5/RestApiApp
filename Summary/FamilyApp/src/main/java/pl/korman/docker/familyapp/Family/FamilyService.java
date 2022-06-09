package pl.korman.docker.familyapp.Family;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.korman.docker.familyapp.Family.DTO.FamilyCreateDTO;
import pl.korman.docker.familyapp.Family.DTO.FamilyMemberRestInputDTO;
import pl.korman.docker.familyapp.Family.DTO.FamilyMemberRestOutputDTO;
import pl.korman.docker.familyapp.Family.DTO.FamilyOutputDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class FamilyService {
    private FamilyRepo familyRepo;

    public Optional<Family> getFamilyById(int id){
        return familyRepo.findById(id);
    }

    //do zrobienia
    public void createNewFamily(FamilyCreateDTO creationDTO){
        Family family = new Family(
                creationDTO.getFamilyName(),
                creationDTO.getNrOfAdults(),
                creationDTO.getNrOfChildren(),
                creationDTO.getNrOfInfants()
        );
        List<FamilyMemberRestOutputDTO> familyMemberOutputDTO = creationDTO.getFamilyMemberdtoList().stream()
                .map(dtoinput -> new FamilyMemberRestOutputDTO(family.getId(),dtoinput.getGivenName(),dtoinput.getFamilyName(),dtoinput.getAge()))
                .collect(Collectors.toList());

        //trzeba zrobić tworzenie nowego członka (uzycie post maping)
        //trzeba zrobić sprawdzanie ilości dzieci
        familyRepo.save(family);
    }

    public FamilyOutputDTO getFamilyOutputDTO(Family family, List<FamilyMemberRestInputDTO> members){
        return new FamilyOutputDTO(
                family.getFamilyName(),
                family.getNrOfAdults(),
                family.getNrOfChildren(),
                family.getNrOfInfants(),
                members
        );
    }

    //do zrobienia
    public boolean validateFamilyData(){
        return true;
    }
}

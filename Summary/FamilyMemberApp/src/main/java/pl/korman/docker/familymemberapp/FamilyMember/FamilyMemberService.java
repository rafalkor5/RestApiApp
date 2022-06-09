package pl.korman.docker.familymemberapp.FamilyMember;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.korman.docker.familymemberapp.FamilyMember.DTO.FamilyMember_CreateDTO;

import java.util.List;

@Service
@AllArgsConstructor
public class FamilyMemberService {
    private FamilyMemberRepo familyMemberRepo;

    public List<FamilyMember> findFamilyMemberByFamilyName(int familyid){
        return familyMemberRepo.findAllByFamilyId(familyid);
    }

    public void createNewMember(FamilyMember_CreateDTO dto){
        FamilyMember familyMember= new FamilyMember(
                dto.getFamilyId(),
                dto.getGivenName(),
                dto.getFamilyName(),
                dto.getAge()
        );
        familyMemberRepo.save(familyMember);
    }


}

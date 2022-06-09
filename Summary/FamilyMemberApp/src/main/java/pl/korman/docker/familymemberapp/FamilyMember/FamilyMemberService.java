package pl.korman.docker.familymemberapp.FamilyMember;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FamilyMemberService {
    private FamilyMemberRepo familyMemberRepo;

    public List<FamilyMember> findFamilyMemberByFamilyName(int familyid){
        return familyMemberRepo.findAllByFamilyId(familyid);
    }

    public void createNewMember(FamilyMember familyMember){
        familyMemberRepo.save(familyMember);
    }


}

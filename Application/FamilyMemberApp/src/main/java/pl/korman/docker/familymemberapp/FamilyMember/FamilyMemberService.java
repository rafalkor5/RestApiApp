package pl.korman.docker.familymemberapp.FamilyMember;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.korman.docker.familymemberapp.FamilyMember.DTO.FamilyMember_CreateDTO;
import pl.korman.docker.familymemberapp.FamilyMember.Mapper.FamilyMemberMapper;


import java.util.List;


@Service
@AllArgsConstructor
public class FamilyMemberService {
    private FamilyMemberRepo familyMemberRepo;


    public List<FamilyMember> findFamilyMemberByFamilyId(int familyid){
        return familyMemberRepo.findAllByFamilyId(familyid);
    }

    public FamilyMember createNewMember(FamilyMember_CreateDTO input){
        return familyMemberRepo.save(FamilyMemberMapper.INSTANCE.DtoToFamilyMember(input));
    }
}

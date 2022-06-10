package pl.korman.docker.familymemberapp.FamilyMember;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.korman.docker.familymemberapp.FamilyMember.DTO.FamilyMember_CreateDTO;

import java.net.URI;


@Service
@AllArgsConstructor
public class FamilyMemberService {
    private FamilyMemberRepo familyMemberRepo;


    public ResponseEntity<Iterable<FamilyMember>> findFamilyMemberByFamilyName(int familyid){
        return ResponseEntity.ok(familyMemberRepo.findAllByFamilyId(familyid));
    }

    public ResponseEntity<?> createNewMember(FamilyMember_CreateDTO input){
        var familyMember = familyMemberRepo.save(new FamilyMember(
                input.getFamilyId(),
                input.getGivenName(),
                input.getFamilyName(),
                input.getAge()
        ));
        return ResponseEntity.created(URI.create("/" + familyMember.getId() )).body(familyMember);
    }
}
